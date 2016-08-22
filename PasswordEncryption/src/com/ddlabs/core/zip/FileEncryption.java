package com.ddlabs.core.zip;

import com.ddlabs.core.zip.ZipUtil;

public class FileEncryption{
	public static void main(String[] args) {
		
		ZipUtil.zipDirWithPassword("C:\\Users\\anveshg\\Desktop\\RptOpt\\TELUS\\trunkSamples\\telus_faq_views_152414_2016-07-19_15_20_08.csv", "C:\\Users\\anveshg\\Desktop\\RptOpt\\TELUS\\trunkSamples\\telus_faq_views_152414.zip", "abcd1234");	
	}
}