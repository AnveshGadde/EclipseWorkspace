/**
 * 
 */
package org.anveshgadde.socketprogramming;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author anveshg
 *
 */
public class MyServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();

			DataInputStream dis = new DataInputStream(s.getInputStream());

			String str = (String) dis.readUTF();

			System.out.println("Message: " + str);

			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
