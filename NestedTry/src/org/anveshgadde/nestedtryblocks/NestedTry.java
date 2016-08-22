/**
 * 
 */
package org.anveshgadde.nestedtryblocks;

/**
 * @author anveshg
 *
 */
public class NestedTry {
	public static void main(String args[]) throws Exception {
		try {
			try {
				System.out.println("going to divide");
			} catch (ArithmeticException e) {
				System.out.println("Failed to execute simple sysout: " +e);
			}
			try {
				int a[] = new int[5];
				a[5] = 4;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			}
			System.out.println("other statement");
		} catch (Exception e) {
			System.out.println("handeled");
		}
		int jg = 5;
		if(jg < 8){
			throw new Exception("value failed");
		}else{
			System.out.println(jg);
		}

		System.out.println("normal flow..");
	}
}
