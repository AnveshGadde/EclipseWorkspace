package org.anveshgadde.palindromecheck;

import java.util.Scanner;

public class PaliCheck {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number to check: ");
		int number = scan.nextInt(), r, sum = 0, temp;

		scan.close();

		temp = number;
		
		while (number > 0) {
			r = number % 10;			
			sum = (sum * 10) + r;			
			number = number/10;
		}
		
		if (temp == sum)
			System.out.println("palindrome number ");
		else
			System.out.println("not palindrome");
	}
}