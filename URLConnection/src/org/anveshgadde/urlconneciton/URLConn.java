/**
 * 
 */
package org.anveshgadde.urlconneciton;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author anveshg
 *
 */
public class URLConn {

	public static void main(String[] args) {

		try {
			URL url = new URL("http://www.javatpoint.com/java-tutorial");

			URLConnection urlconn = url.openConnection();

			InputStream is = urlconn.getInputStream();

			int i;

			while ((i = is.read()) != -1) {
				System.out.println((char) i);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}