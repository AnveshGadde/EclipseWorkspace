package org.anveshgadde.finalkeyword;

import java.util.Scanner;

public class FinalVariable {

	String name;
	int age;
	final String Profession;

	Scanner scan = new Scanner(System.in);

	FinalVariable() {
		System.out.println("Please, enter your profession here!");
		Profession = scan.nextLine();
	}

	void industryWork() {
		System.out.println("You belong to "+((Profession.toLowerCase().contains("hadoop") ? "BigData" : "InformationTechnology"))+" industry");
	}

	public static void main(String[] args) {

		new FinalVariable().industryWork();

	}

}