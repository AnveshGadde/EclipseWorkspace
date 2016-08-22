package org.anveshgadde.staticmethod;

class UserInfo {

	String name;
	String place;
	static String address = "Mississauga";


	UserInfo(String n, String p) {
		this.name = n;
		this.place = p;
	}

	void display() {
		System.out.println("Name & Address: " + name + " " + place + " " + address);
	}
}

public class StaticInfo {

	public static void main(String[] args) {

		UserInfo uif = new UserInfo("Anvesh", "10 Sledman");
		UserInfo ufi = new UserInfo("Deepak", "markham");

		uif.display();

		ufi.display();
	}
}
