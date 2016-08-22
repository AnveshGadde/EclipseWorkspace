package com.ddlabs.core.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


import net.sf.sevenzipjbinding.ExtractOperationResult;
import net.sf.sevenzipjbinding.ISequentialOutStream;
import net.sf.sevenzipjbinding.ISevenZipInArchive;
import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.SevenZipException;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.simple.ISimpleInArchive;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;


import de.idyl.crypto.zip.AesZipFileEncrypter;

public final class ZipUtil 
{

	private static void writeFile( File file , ZipInputStream zipIn)
	{
			try {
			OutputStream outStream = new FileOutputStream(file);
			byte[] buff = new byte[1024];
			int len;
			while ((len = zipIn.read(buff)) > 0) {
			outStream.write(buff, 0, len);
			}
			outStream.close();
			}
			catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	
	private static void extract(File srcZipfile, File destinationDir) throws IOException
	{
			ZipInputStream zipIn = null;
			try {
			zipIn = new ZipInputStream(new FileInputStream(srcZipfile));
			ZipEntry entry = null;
			
			while ((entry = zipIn.getNextEntry()) != null) {
			String outFilename = entry.getName();
			if( !new File(destinationDir, outFilename).getParentFile().exists() )
			new File(destinationDir, outFilename).getParentFile().mkdirs();
			if( !entry.isDirectory() )
			writeFile(new File(destinationDir,outFilename), zipIn);
			}
			
			System.out.println("Zip file extracted successfully...");
			} 
			catch( Exception e ){
			e.printStackTrace();
			}
			finally {
			if (zipIn != null) {
			zipIn.close();
			}
			}
	}

	
	private static void compressDir(String directory, ZipOutputStream zos, String path) throws IOException {
		File zipDir = new File(directory);
		String[] dirList = zipDir.list();
		byte[] readBuffer = new byte[2156];
		int bytesIn = 0;
		for (int i = 0; i < dirList.length; i++) {
			File f = new File(zipDir, dirList[i]);
			if (f.isDirectory()) {
				String filePath = f.getPath();
				compressDir(filePath, zos, path + f.getName() + "/");
				continue;
			}
			FileInputStream fis = new FileInputStream(f);
			try {
				ZipEntry anEntry = new ZipEntry(path + f.getName());
				zos.putNextEntry(anEntry);
				bytesIn = fis.read(readBuffer);
				while (bytesIn != -1) {
					zos.write(readBuffer, 0, bytesIn);
					bytesIn = fis.read(readBuffer);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fis.close();
			}
		}
	}


	private static void zipDir(String dirName, String zipFileName) {
		{
			if( zipFileName == null )
			{
			File tempFile = new File(dirName);
			zipFileName = tempFile.getAbsoluteFile().getParent()+ File.separator+tempFile.getName()+".zip";
			}
			try 
			{
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFileName));
			compressDir(dirName, zos, new File(dirName).getName()+File.separator);
			zos.close();
			}
			catch( NullPointerException npe )
			{
			npe.printStackTrace();
			}
			catch (FileNotFoundException e)
			{
			e.printStackTrace();
			}
			catch( IOException ie )
			{
			ie.printStackTrace();
			}
			}		
	}

	public static void zipDirWithPassword( String dirName , String zipFileName , String password)
	{
			if( zipFileName == null ) {
			File tempFile = new File(dirName);
			zipFileName = tempFile.getAbsoluteFile().getParent() +File.separator+tempFile.getName()+".zip";
			}
			zipDir(dirName, zipFileName);
			String tempZipFileName = new File( dirName ).getAbsoluteFile() .getParent()+File.separator+"tempencrypted.zip";
			
			try{
			AesZipFileEncrypter enc = new AesZipFileEncrypter (tempZipFileName);
			enc.addEncrypted( new File(zipFileName), password);
			new File(zipFileName).delete();
			new File( tempZipFileName ).renameTo( new File (zipFileName));
			}
			catch (IOException e) {
			e.printStackTrace();
			}
	}


	public static void unzipDir(String sourceZipFile, String destinationDir)
	{
			try{
			extract( new File(sourceZipFile), new File(destinationDir));
			}
			catch( Exception e ){
			e.printStackTrace();
			}
	}
	
	
	public static void unzipDirWithPassword( final String sourceZipFile , final String destinationDir , final String password )
	{
		RandomAccessFile randomAccessFile = null;
		ISevenZipInArchive inArchive = null;
		try 
		{
			randomAccessFile = new RandomAccessFile(sourceZipFile, "r");
			inArchive = SevenZip.openInArchive(null, // autodetect archive type
			new RandomAccessFileInStream(randomAccessFile));
 
			ISimpleInArchive simpleInArchive = inArchive.getSimpleInterface();
			
			for (final ISimpleInArchiveItem item : simpleInArchive.getArchiveItems()) 
			{
				final int[] hash = new int[] { 0 };
				if (!item.isFolder()) 
				{
					ExtractOperationResult result;
					result = item.extractSlow(new ISequentialOutStream() 
					{
						public int write(final byte[] data) throws SevenZipException 
						{
							try {
							if(item.getPath().indexOf(File.separator)>0){
								String path = destinationDir+File.separator+item.getPath(). substring(0,item.getPath().lastIndexOf(File.separator));
								File folderExisting = new File(path);  
								if (!folderExisting.exists())
								new File(path).mkdirs();
							}
							OutputStream out = new FileOutputStream(destinationDir+ File.separator+item.getPath());
							out.write(data);
							out.close();
							}
							catch( Exception e ){
							e.printStackTrace();
							}
					
							hash[0] |= Arrays.hashCode(data);
							return data.length; // Return amount of proceed data
						}},password); /// password 
					if (result == ExtractOperationResult.OK) 
					{
					System.out.println(String.format("%9X | %s", hash[0], item.getPath()));
					}
					else { System.err.println("Error extracting item: " + result); }
				}
				
			}
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		finally
		{
			if (inArchive != null)
			{
				try {
				inArchive.close();
				}
				catch (SevenZipException e){
				System.err.println("Error closing archive: " + e);
				e.printStackTrace();
				}
			}
			if (randomAccessFile != null) 
			{
				try {
				randomAccessFile.close();
				}
				catch (IOException e) {
				System.err.println("Error closing file: " + e);
				e.printStackTrace();
				}
			}
		}
	}
}