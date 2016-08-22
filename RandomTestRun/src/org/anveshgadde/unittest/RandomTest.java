package org.anveshgadde.unittest;

import java.util.Scanner;

public class RandomTest {

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter eventID: ");
		int eventID = scan.nextInt();

		System.out.println("Enter the number: ");
		int errorCode = scan.nextInt();

		if (eventID == 23 && (errorCode == 1012 || errorCode == 1013 || (errorCode > 1500 && errorCode < 1599))) {
			System.out.println("Auto-Box passed!");
		} else {
			System.out.println("Bug detected!");
		}

		scan.close();
	}
}