/**
 * 
 */
package org.anveshgadde.socketprogramming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author anveshg
 *
 */
public class MyClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Socket s = new Socket("localhost", 6666);

			DataOutputStream dos = new DataOutputStream(s.getOutputStream());

			dos.writeUTF("Server side server pinged");

			dos.flush();
			dos.close();

			s.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
