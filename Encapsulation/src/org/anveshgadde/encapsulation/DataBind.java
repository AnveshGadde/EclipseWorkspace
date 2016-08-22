package org.anveshgadde.encapsulation;

import java.util.Scanner;

class DataSetUp {
	private String userName;
	private int age;

	public String getName() {
		return userName;
	}

	public void setName(String name) {
		this.userName = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void userDip() {
		System.out.println("UserDisplay information is: " +userName+ " and "+age+" years old!");
	}

}

public class DataBind {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name here: ");
		String name = scan.nextLine();

		DataSetUp dsu = new DataSetUp();

		dsu.setName(name);
		dsu.setAge(27);
		
		dsu.userDip();

		scan.close();

	}

}
