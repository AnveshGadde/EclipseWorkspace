package org.anveshgadde.overloadconstructors;

import java.util.Scanner;

public class SwapConstructors {

	String name;
	int id;
	String gender;

	SwapConstructors(String userName, int userID, String userGender) {
		this.name = userName;
		this.id = userID;
		this.gender = userGender.toLowerCase();
	}

	void displayUser() {
		System.out.println("The user details are " + name + " : " + id + " : " + gender);
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter your name here: ");
		String userName = scan.nextLine();

		System.out.println("Enter your id here: ");
		int userID = scan.nextInt();

		System.out.println("Enter your gender here: ");
		String userGender = scan.nextLine();

		scan.close();

		SwapConstructors subs = new SwapConstructors(userName, userID, userGender);

		subs.displayUser();

	}
}