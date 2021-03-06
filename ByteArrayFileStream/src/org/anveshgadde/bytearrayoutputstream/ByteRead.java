/**
 * 
 */
package org.anveshgadde.bytearrayoutputstream;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

/**
 * @author anveshg
 *
 */
public class ByteRead {
	public static void main(String args[]) throws Exception {
		FileOutputStream fout1 = new FileOutputStream("C:/Users/anveshg/Desktop/f1.txt");
		FileOutputStream fout2 = new FileOutputStream("C:/Users/anveshg/Desktop/f2.txt");
		
		String name = "Anvesh";
		
		byte[] b = name.getBytes();
		
		System.out.println("Converted string: " +b);
		
		FileOutputStream fbout = new FileOutputStream("C:/Users/anveshg/Desktop/byteConverted.txt");	
		
		fbout.write(b);
		fbout.close();

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		bout.write(139);
		bout.writeTo(fout1);
		bout.writeTo(fout2);

		bout.flush();
		bout.close();// has no effect
		System.out.println("success...");
	}
}
