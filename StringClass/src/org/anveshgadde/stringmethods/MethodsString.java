/**
 * 
 */
package org.anveshgadde.stringmethods;

import java.util.Locale;

/**
 * @author anveshg
 *
 */
public class MethodsString {

	public static void main(String[] args) {

		char[] myInitial = { 'G', 'a', 'd', 'd', 'e' };
		String myName = "AnveshGadde";
		
		//String defName = null;

		String myNumber = "125";

		// char index method
		System.out.println("String char index method: " + myName.charAt(4));

		// length method
		System.out.println("String myName length: " + myName.length());
		System.out.println("String myNumber length: " + myNumber.length());

		// Formatted string
		System.out.println("String myName formatted: " + String.format("%1s", myName));
		System.out.println("String myName formatted locale: " + String.format(Locale.ITALIAN, "%1s", myName));

		// Substring
		System.out.println("String myName subString: " + myName.substring(2));
		System.out.println("String myName subString with endIndex: " + myName.substring(2, myName.length() - 1));

		// boolean check
		System.out.println("String boolean check: " + myName.toLowerCase().contains("ve"));

		// String join operation
		// System.out.println("String join operation: "
		// +String.join("|",myInitial)); Java 8 or above

		// boolean check for another object
		System.out.println("String boolean object equals: " + Boolean.valueOf(myName.equals(new String(myInitial))));
		System.out
				.println("String boolean object equals with boolean value of: " + myName.equals(new String(myInitial)));

		// boolean check for empty
		System.out.println("String boolean check for empty: " + myName.isEmpty());

		// String concatenation
		System.out.println("String concatenation: " + myName.concat(" kumar"));

		// Char replace in String
		System.out.println("Char replace in string: " + myName.replace('A', 'X'));
		System.out.println("Char sequence replace: " + myName.replace('e', 'f'));

		// String trim
		System.out.println("Trimmed string value is: " + myName.trim());
	}

}
