/**
 * 
 */
package org.anveshgadde.sequenceiostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

/**
 * @author anveshg
 *
 */
public class SequenceIOStream {

	public static void main(String[] args) throws FileNotFoundException {

		try {
			FileInputStream fis1, fis2;
			fis1 = new FileInputStream("C:\\Users\\anveshg\\Desktop\\f1.txt");
			fis2 = new FileInputStream("C:\\Users\\anveshg\\Desktop\\f2.txt");

			FileOutputStream fout = new FileOutputStream("C:\\Users\\anveshg\\Desktop\\f2.txt");

			SequenceInputStream sis = new SequenceInputStream(fis1, fis2);

			int i = 0;

			while ((i = sis.read()) != 1) {
				fout.write(i);
			}
			fis1.close();
			fis2.close();
			sis.close();
			fout.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
