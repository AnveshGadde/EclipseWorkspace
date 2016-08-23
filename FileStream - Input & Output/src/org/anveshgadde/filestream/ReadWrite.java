/**
 * 
 */
package org.anveshgadde.filestream;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author anveshg
 *
 */
public class ReadWrite {

	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\anveshg\\Desktop\\GenericUDTFJSONTuple.java");
			FileOutputStream fos = new FileOutputStream("C:\\Users\\anveshg\\Desktop\\OutputStream.java");
			FileOutputStream fileos = new FileOutputStream("C:\\Users\\anveshg\\Desktop\\2ndOs.java");
			ByteArrayOutputStream bout = new ByteArrayOutputStream();

			System.out.println("Reading file: " + fis.read());
			int i = 0;

			bout.write(i);
			bout.writeTo(fos);
			bout.writeTo(fileos);

			System.out.println("Data written, flushing starts---->");

			fis.close();
			fos.close();
			fileos.close();

			bout.flush();
			bout.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
