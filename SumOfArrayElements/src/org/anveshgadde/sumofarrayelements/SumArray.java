package org.anveshgadde.sumofarrayelements;

import java.util.Scanner;

/**
 * @author anveshg
 *
 */
public class SumArray {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the number of elements in the array: ");
		int[] intArray = new int[scan.nextInt()];

		int sumResult = 0;

		for (int i = 0; i < intArray.length; i++) {
			System.out.println("The " + i + " element of array is: ");
			intArray[i] = scan.nextInt();
		}

		for (int result : intArray) {
			sumResult = sumResult + result;
		}

		System.out.println("Result is: " + sumResult);

		scan.close();

	}

}
