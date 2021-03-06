/**
 * 
 */
package org.anveshgadde.mutableandimmutable;

/**
 * @author anveshg
 *
 */
public class Mutation {

	public static void main(String[] args) {

		String myName = "Anvesh";

		String myNameDup = "anvesh";

		String myNewName = "Gadde";

		System.out.println(myName.concat("kumar") + " " + myNewName + "|" + myNameDup);

		System.out.println("Boolean value with case sensitive: " + myName.equals(myNameDup));
		
		System.out.println("Boolean value with case ignore: " + myName.equalsIgnoreCase(myNameDup));
		
		System.out.println("Boolean value for starts with and ends with: " + myName.toLowerCase().startsWith("n") + " ||" + myName.toUpperCase().endsWith("SH"));
		
		System.out.println("Intern value: " + myName.intern().equalsIgnoreCase(myNewName));
	}

}
