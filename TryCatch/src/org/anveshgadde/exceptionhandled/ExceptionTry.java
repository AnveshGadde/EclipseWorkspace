/**
 * 
 */
package org.anveshgadde.exceptionhandled;

import java.util.Scanner;

/**
 * @author anveshg
 *
 */
public class ExceptionTry {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();

		sc.close();

		try {
			System.out.println("Div value: " + i / 0);
		} catch (ArithmeticException e) {
			System.out.println("StackTrace: " +e);
		} finally {
			System.out.println("Finally block involved!");
		}

	}

}
