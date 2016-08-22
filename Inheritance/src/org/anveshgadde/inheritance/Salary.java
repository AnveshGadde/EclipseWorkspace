/**
 * 
 */
package org.anveshgadde.inheritance;

import java.util.Scanner;

/**
 * @author anveshg
 *
 */
public class Salary extends BonusPercentage {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter your designation here please: ");
		String designation = scan.nextLine();

		System.out.println("Your experience please: ");
		float experience = scan.nextFloat();

		scan.close();

		switch (designation) {

		case "Programmer":
			System.out.println("Hey Crazy Programmer, your salary increase is : "
					+ (((BonusPercentage.bonus) * experience) / 100));
			break;

		case "Tester":
			System.out.println(
					"Oh QA analyst, your salary increase is: " + (((BonusPercentage.bonus) * experience) - 2 / 100));
			break;

		case "Manager":
			System.out.println(
					"Mr/Mrs Manager, your salary increase is: " + (((BonusPercentage.bonus) * experience * 5) / 100));
			break;
			
		default:
			System.out.println("Did not match the criteria");
			break;

		}

	}
}
