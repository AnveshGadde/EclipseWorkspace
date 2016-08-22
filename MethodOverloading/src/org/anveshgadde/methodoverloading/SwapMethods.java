/**
 * 
 */
package org.anveshgadde.methodoverloading;

/**
 * @author anveshg
 *
 */
public class SwapMethods {

	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public final static void main(String[] args) {


		new SubMethods().sum(11, 6, 10);

		MainMethod mm = new MainMethod();

		mm.main(10);

	}

}

class MainMethod {
	public final static void main(int a) {
		System.out.println("main method invoked: " + a);
	}
}

class SubMethods {

	final void sum(int a, int b) {
		System.out.println("The sum result is: " + (a + b));
	}

	final void sum(int a, int b, int c) {
		System.out.println("The div result is: " + (a + b+c));
	}

}
