package org.anveshgadde.accessmodifiers;

class normalModify {
	private String name;

	protected normalModify(String name) {
		this.name = name;
	}

	protected void displayInfo() {
		System.out.println("Name entered is: " + name);
	}
}

public class Modifiers extends normalModify {
	protected Modifiers(String name) {
		super(name);
	}

	public static void main(String[] args) {

		String name = null;
		
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				name = args[0];
			}
		}

		normalModify mod = new Modifiers(name);

		mod.displayInfo();

	}

}
