package org.anveshgadde.fibonacci;

import java.util.Scanner;

/**
 * Java class to list the Fibonacci series up to given n numbers.
 */

public class Fibonacci {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();

		int start = 0, next = 1, result, input; 
		
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the series limit: ");
		input = scan.nextInt();

		scan.close();

		System.out.print("Fibonacci Series: " + start + ", " + next);
		for (int i = 2; i < input; i++) {

			// producing next value in the series
			result = start + next;
			System.out.print(", " + result);

			// Replacing the values at the index
			start = next;
			next = result;

		}

		long endTime = System.currentTimeMillis();
		
		System.out.println("Took "+(endTime - startTime) + " ms");
	}
}