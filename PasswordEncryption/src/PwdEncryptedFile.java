import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

import de.schlichtherle.truezip.crypto.param.AesKeyStrength;
import de.schlichtherle.truezip.zip.WinZipAesParameters;
import de.schlichtherle.truezip.zip.ZipEntry;
import de.schlichtherle.truezip.zip.ZipKeyException;
import de.schlichtherle.truezip.zip.ZipOutputStream;

public class PwdEncryptedFile {
	public static void main(String[] args) throws IOException {

		List<String> fileList = new ArrayList<String>();

		String zipPassword = "anvesh";

		final String faqCSV = "telus_faq_views_152414_2016-07-19_15_20_08.csv",
				rentalCSV = "rental_purchase_152418_2016-07-19_15_41_12.csv",
				playbackUsageCSV = "telus_playback_usage_152417_2016-07-19_15_35_37.csv",
				playbackErrorCSV = "telus_playback_error_152416_2016-07-19_15_31_41.csv",
				loginLogoutCSV = "telus_login_logout_152415_2016-07-19_15_27_05.csv",
				outputReportFilePath = "C:\\Users\\anveshg\\Desktop\\RptOpt\\TELUS\\trunkSamples";

		fileList.add(faqCSV);
		fileList.add(rentalCSV);
		fileList.add(playbackUsageCSV);
		fileList.add(playbackErrorCSV);
		fileList.add(loginLogoutCSV);

		StringBuilder emailContent = new StringBuilder();

		for (String fileQueue : fileList) {

			File fileCheck = new File(FilenameUtils.concat(outputReportFilePath, fileQueue));

			if (!fileCheck.exists()) {
				emailContent.append(fileQueue);
				emailContent.append("  did not generate");
				emailContent.append(System.getProperty("line.separator"));

			} else {

				String zipFileName = FilenameUtils.concat(outputReportFilePath, fileQueue.replaceAll(".csv", ".zip"));

				byte[] buffer = new byte[1024];

				final byte[] filePassword = zipPassword.getBytes(Charset.forName("UTF-8")).clone();

				ZipOutputStream zipOutput = new ZipOutputStream(new FileOutputStream(zipFileName));
				zipOutput.setCryptoParameters(new WinZipAesParameters() {
					public byte[] getWritePassword(String name) throws ZipKeyException {
						return filePassword.clone();
					}

					public byte[] getReadPassword(String name, boolean invalid) throws ZipKeyException {
						if (invalid)
							throw new ZipKeyException(name + " (invalid password)");
						return filePassword.clone();
					}

					public AesKeyStrength getKeyStrength(String arg0) throws ZipKeyException {
						return AesKeyStrength.BITS_256;
					}

					public void setKeyStrength(String name, AesKeyStrength keyStrength) throws ZipKeyException {
						assert AesKeyStrength.BITS_256 == keyStrength;
					}
				});
				ZipEntry zipEntry = new ZipEntry(fileQueue);
				zipEntry.setEncrypted(true);
				FileInputStream fis = new FileInputStream(FilenameUtils.concat(outputReportFilePath, fileQueue));
				zipOutput.putNextEntry(zipEntry);

				int fileLength;

				while ((fileLength = fis.read(buffer)) > 0) {
					zipOutput.write(buffer, 0, fileLength);
				}

				zipOutput.close();
				fis.close();

				emailContent.append(fileQueue);
				emailContent.append("  successfully generated");
				emailContent.append(System.getProperty("line.separator"));
			}
		}
		
		System.out.println("EmailMessage is: " + emailContent.toString());
	}
}