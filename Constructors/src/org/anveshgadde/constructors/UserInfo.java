package org.anveshgadde.constructors;

import java.util.Scanner;

class InfoStore {
	private static String firstName;
	final String middleName;
	String lastName;
	int age;
	double salary;
	String locProvince;
	char status;

	@SuppressWarnings("static-access")
	InfoStore(String firstName, String middleName, String lastName, int age, double salary, String locProvince, char status) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
		this.locProvince = locProvince;
		this.status = status;
	}

	void display() {
		System.out.println("User info is as follows: ");
		System.out.println("FirstName: " + firstName);
		System.out.println("MiddleName: " +middleName);
		System.out.println("LastName: " + lastName);
		System.out.println("Age: " + age + " yrs old!");
		System.out.println("Salary per annum: " + salary + " $ CAD");
		System.out.println("Province: " + locProvince);
		System.out.println("Marital Status: " + status);
	}

}

public class UserInfo {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.print("Your FirstName: ");
		String nameFirst = in.nextLine();
		
		System.out.print("Your MiddleName: ");
		String nameMiddle = in.nextLine();

		System.out.print("Your LastName: ");
		String nameLast = in.nextLine();

		System.out.print("Your age: ");
		int age = in.nextInt();

		System.out.print("Your Salaryearned: ");
		double salary = in.nextDouble();

		System.out.println("Your ProvinceName: ");
		String province = in.nextLine();

		System.out.println("Are you married?: ");
		char status = in.nextLine().charAt(0);

		in.close();

		InfoStore iS = new InfoStore(nameFirst, nameMiddle, nameLast, age, salary, province, status);

		iS.display();
	}
}