package org.anveshgadde.filedirectorycheck;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDirectoryCheck {
	public static void main(String[] args) throws IOException {

		String fileName = "C:\\Users\\anveshg\\Desktop\\RptOpt\\TELUS\\trunkSamples\\telus_faq_views_152414_2016-07-19_15_20_08.csv";
		
		String fileClone = fileName.replaceFirst(".csv", ".zip");
		
		System.out.println(fileName+" to "+fileClone);
		
		
		FileInputStream fis = new FileInputStream("C:\\Users\\anveshg\\Desktop\\RptOpt\\TELUS\\trunkSamples\\telus_faq_views_152414_2016-07-19_15_20_08.csv");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\anveshg\\Desktop\\RptOpt\\TELUS\\trunkSamples\\telus_faq_views_transformed.csv");
		
		int i = 0;
		 
		while((i=fis.read()) != -1){
			fos.write((byte)i);
		}
		
		fis.close();
		fos.close();
	}
}
