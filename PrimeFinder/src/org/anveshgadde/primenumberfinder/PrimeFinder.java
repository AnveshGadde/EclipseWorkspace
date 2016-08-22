package org.anveshgadde.primenumberfinder;

import java.util.Scanner;

public class PrimeFinder {
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number to check: ");
		int number = in.nextInt(), flag = 0;
		
		in.close();

		for (int i = 2; i < (number/2); i++) {

			if (number % i == 0) {
				System.out.println(number + " is not a prime number");
				flag = 1;
				break;
			} 
		}
		
		if(flag == 0)	System.out.println(number + " is a Prime number");
	}
}
