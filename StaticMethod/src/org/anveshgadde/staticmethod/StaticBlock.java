package org.anveshgadde.staticmethod;

public class StaticBlock {

	static{
		System.out.println("Static block got invoked!");
	}
	
	public static void main(String[] args) {
		System.out.println("Hello from main()!");
	}
}

/*------------------------without-main()-----------------------------
 * 
 * 
 * public class StaticBlock {
 * 
 * static{
 * sysout("hello");
 * system.exit(0);
 * }
 * 
 * Fails if JDK is >1.7 * 
 * 
 * */

