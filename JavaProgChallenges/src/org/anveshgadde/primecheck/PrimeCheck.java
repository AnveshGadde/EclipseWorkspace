package org.anveshgadde.primecheck;

import java.util.Scanner;

class Input {

	private int number;

	public Input(int number) {
		this.number = number;
	}

	public void result() {
		String result = null;

		for (int i = 2; i <= number / 2; i++) {
			result = (number % i == 0) ? "Not Prime" : "Prime";
			if ("Not Prime".equalsIgnoreCase(result))
				break;
		}

		System.out.println("Input " + number + " is " + result);
	}
}

public class PrimeCheck {

	public static void main(String[] args) {

		System.out.println("Please enter the number to check...............");
		Scanner console = new Scanner(System.in);
		int number = console.nextInt();

		Input in = new Input(number);

		in.result();
		console.close();
	}
}
