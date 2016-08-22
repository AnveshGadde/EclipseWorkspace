package org.anveshgadde.crypto;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class CryptoUtilsTest {

	public static void main(String[] args) throws UnsupportedEncodingException, CryptoException {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the password ");
		String key = "anvesh";
		
		final byte[] utf8Bytes = key.getBytes("UTF-8");
		
		System.out.println(utf8Bytes.length);
				
		File inputFile = new File("C:\\Users\\anveshg\\Desktop\\RptOpt\\TELUS\\trunkSamples\\rental_purchase_152418_2016-07-19_15_41_12.csv");
		
		File encryptedFile = new File("C:\\Users\\anveshg\\Desktop\\RptOpt\\TELUS\\trunkSamples\\rental_purchase_Encrypted.csv");
		
		File decryptedFile = new File("C:\\Users\\anveshg\\Desktop\\RptOpt\\TELUS\\trunkSamples\\rental_purchase_Decrypted.csv");
		
		try {
			CryptoUtils.encrypt(key, inputFile, encryptedFile);
			CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan.close();
	}

}
