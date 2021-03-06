package org.anveshgadde.inputreverse;

import java.util.Scanner;

/**
 * @author anveshg
 *
 */

public class ReverseInput {
	public static void main(String[] args) {

		System.out.println("Enter the type of variable to be reversed: ");
		Scanner scan = new Scanner(System.in);
		char check = scan.nextLine().charAt(0);

		StringBuilder sbr = new StringBuilder();

		if (check == 's') {
			System.out.println("Enter the string to be reversed: ");
			String str = scan.nextLine();

			sbr.append(str);
			sbr = sbr.reverse();
			System.out.println("Reversed string value: ");

			for (int i = 0; i < sbr.length(); i++) {
				System.out.print(sbr.charAt(i));
			}
		} else if (check == 'i') {
			System.out.println("Enter the integer to be reversed: ");
			int revInt = scan.nextInt();

			sbr.append(revInt);
			sbr = sbr.reverse();
			System.out.println("Reversed integer value: ");

			for (int i = 0; i < sbr.length(); i++) {
				System.out.print(sbr.charAt(i));

			}
		} else {
			System.err.println("This " + check + " type cannot be converted!x!");
		}

		scan.close();

	}

}
