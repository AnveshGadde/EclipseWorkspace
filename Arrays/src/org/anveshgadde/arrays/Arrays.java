package org.anveshgadde.arrays;

public class Arrays {
	public static void main(String[] args) {

		int[] ageValues = new int[5];

		for (int i = 0; i < ageValues.length; i++) {

			ageValues[i] = ((i * 2) + 5) / 3;

			System.out.println(i + " : " + ageValues[i]);
		}

		String[] namesArr = new String[5];

		namesArr[0] = "Gadde";
		namesArr[1] = "Anvesh";
		namesArr[2] = "Kumar";

		for (String name : namesArr) {
			System.out.println(name);
		}

	}
}
