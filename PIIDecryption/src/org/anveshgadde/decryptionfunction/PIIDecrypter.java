package org.anveshgadde.decryptionfunction;

import java.io.IOException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde.Constants;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.StringObjectInspector;
import org.apache.hadoop.io.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.quickplay.security.crypto.CipherV2;
import com.quickplay.security.error.SecurityException;
import com.strongauth.strongkeylite.web.Encryption;
import com.strongauth.strongkeylite.web.EncryptionService;
import com.strongauth.strongkeylite.web.StrongKeyLiteException_Exception;

public class PIIDecrypter extends GenericUDF {

	private static final int NO_ARGUMENTS = 3;

	private static final Logger LOGGER = LoggerFactory.getLogger(PIIDecrypter.class);

	private transient ObjectInspector[] inputOIs;
	private transient Text result = new Text();

	private transient Base64 base64 = new Base64();

	private transient String userName;
	private transient String password;
	private transient Long did;

	private transient Encryption encryption;

	private transient Map<EncryptionParameters, Cipher> encryptionSecretCache = new HashMap<EncryptionParameters, Cipher>();

	private transient Set<EncryptionParameters> irretrievableTokens = new HashSet<EncryptionParameters>();

	private transient CipherV2 passwordCipher = new CipherV2();

	@Override
	public ObjectInspector initialize(ObjectInspector[] arguments) throws UDFArgumentException {
		initEncryptionService();
		inputOIs = arguments;

		checkArguments(arguments);
		return PrimitiveObjectInspectorFactory.writableStringObjectInspector;
	}

	private void checkArguments(ObjectInspector[] arguments) throws UDFArgumentException {
		if (arguments.length != NO_ARGUMENTS) {
			throw new UDFArgumentException("pii_decrypt() takes 3 arguments");
		}
		checkEncryptedValueArgument(arguments);
		checkStrongAuthTokenArgument(arguments);
		checkEncryptionAlgorithmArgument(arguments);

	}

	private void checkEncryptionAlgorithmArgument(ObjectInspector[] arguments) throws UDFArgumentException {
		if (arguments[2].getCategory() != ObjectInspector.Category.PRIMITIVE
				|| !arguments[2].getTypeName().equals(Constants.STRING_TYPE_NAME)) {
			throw new UDFArgumentException("algorithm to decrypt must be string type");
		}
	}

	private void checkStrongAuthTokenArgument(ObjectInspector[] arguments) throws UDFArgumentException {
		if (arguments[1].getCategory() != ObjectInspector.Category.PRIMITIVE
				|| !arguments[1].getTypeName().equals(Constants.STRING_TYPE_NAME)) {
			throw new UDFArgumentException("token to strongauth must be string type");
		}
	}

	private void checkEncryptedValueArgument(ObjectInspector[] arguments) throws UDFArgumentException {
		if (arguments[0].getCategory() != ObjectInspector.Category.PRIMITIVE
				|| !arguments[0].getTypeName().equals(Constants.STRING_TYPE_NAME)) {
			throw new UDFArgumentException("value to decrypt must be string type");
		}
	}

	private void initEncryptionService() throws UDFArgumentException {

		FSDataInputStream inputStream = null;

		try {
			FileSystem fileSystem = FileSystem.get(new Configuration());
			inputStream = fileSystem.open(new Path("C:\\Users\\anveshg\\Desktop\\strong_auth.properties"));
			Properties properties = new Properties();
			properties.load(inputStream);
			String host = properties.getProperty("strongauth.host");
			Integer port = Integer.parseInt(properties.getProperty("strongauth.port"));
			String wsdlSuffix = properties.getProperty("strongauth.wsdl");
			userName = properties.getProperty("strongauth.username");
			password = passwordCipher.decrypt(properties.getProperty("strongauth.password"));
			did = Long.parseLong(properties.getProperty("strongauth.did"));

			URL url = new URL(EncryptionService.class.getResource("."), host + ":" + port + wsdlSuffix);
			EncryptionService encryptionService = new EncryptionService(url);
			encryption = encryptionService.getEncryptionPort();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(inputStream);
		}

	}

	private void close(FSDataInputStream inputStream) {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				LOGGER.error("could not close stream", e);
			}
		}
	}

	private Cipher getCipher(String token, String algorithmName) throws HiveException {
		EncryptionParameters encryptionParameters = new EncryptionParameters(token, algorithmName);
		if (irretrievableTokens.contains(encryptionParameters)) {
			throw new HiveException("token not found in StrongAuth in previous retrieval");
		}

		Cipher cipher = encryptionSecretCache.get(encryptionParameters);
		if (cipher == null) {
			cipher = createCipher(encryptionParameters);
			encryptionSecretCache.put(encryptionParameters, cipher);
		}
		return cipher;
	}

	private Cipher createCipher(EncryptionParameters encryptionParameters) throws HiveException {

		try {
			Cipher cipher = Cipher.getInstance(encryptionParameters.getAlgorithm());
			String seed = encryption.decrypt(did, userName, password, encryptionParameters.getToken());
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(seed.getBytes(), encryptionParameters.getAlgorithm()));
			return cipher;
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			throw newDecryptionException(e);
		} catch (StrongKeyLiteException_Exception e) {
			addIrretrievableTokens(encryptionParameters, e);
			throw newDecryptionException(e);
		} catch (InvalidKeyException e) {
			throw newDecryptionException(e);
		}
	}

	private HiveException newDecryptionException(Exception e) {
		return new HiveException("failed decrypting", e);
	}

	private void addIrretrievableTokens(EncryptionParameters encryptionParameters, StrongKeyLiteException_Exception e) {
		if (e.getMessage().contains("SKL-ERR-1011")) {
			irretrievableTokens.add(encryptionParameters);
		}
	}

	@Override
	public Object evaluate(DeferredObject[] arguments) throws HiveException {
		if (arguments.length == NO_ARGUMENTS) {
			for (DeferredObject argument : arguments) {
				if (argument.get() == null) {
					return null;
				}
			}
		} else {
			return null;
		}

		String valueToDecrypt = ((StringObjectInspector) inputOIs[0]).getPrimitiveJavaObject(arguments[0].get());
		String token = ((StringObjectInspector) inputOIs[1]).getPrimitiveJavaObject(arguments[1].get());
		String algorithmName = ((StringObjectInspector) inputOIs[2]).getPrimitiveJavaObject(arguments[2].get());
		String decryptedValue = decrypt(valueToDecrypt, token, algorithmName);
		result.set(decryptedValue);
		return result;
	}

	@Override
	public String getDisplayString(String[] children) {
		assert children.length > 0;
		StringBuilder sb = new StringBuilder("PIIDecrypt(");
		for (String string : children) {
			sb.append(string).append(",");
		}
		sb.delete(sb.length() - 1, sb.length()).append(")");
		return sb.toString();
	}

	String decrypt(String value, String token, String algorithmName) throws HiveException {

		byte[] decodedValue = base64.decode(value);
		byte[] decryptedValue = null;

		try {
			Cipher cipher = getCipher(token, algorithmName);
			decryptedValue = cipher.doFinal(decodedValue);
		} catch (BadPaddingException e) {
			throw new HiveException("exception decrypting value", e);
		} catch (IllegalBlockSizeException e) {
			throw new HiveException("exception decrypting value", e);
		}
		return new String(decryptedValue).trim();
	}
}