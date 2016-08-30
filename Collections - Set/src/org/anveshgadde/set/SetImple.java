package org.anveshgadde.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetImple {
	public static void main(String[] args) {

		HashSet<String> hs = new HashSet<String>();

		hs.add("Anvesh");
		hs.add("Kumar".toLowerCase());
		hs.add("gadde".toUpperCase());
		hs.add("Anvesh");

		System.out.println("HashSet representation: ");
		System.out.println(hs);
		System.out.println(System.lineSeparator());

		LinkedHashSet<String> lhs = new LinkedHashSet<String>();

		lhs.add("Anvesh");
		lhs.add("Kumar".toLowerCase());
		lhs.add("gadde".toUpperCase());
		lhs.add("Anvesh");

		System.out.println("LinkedHashSet representation: ");
		System.out.println(lhs);
		System.out.println(System.lineSeparator());

		TreeSet<String> ts = new TreeSet<String>();

		ts.add("Anvesh");
		ts.add("Kumar".toLowerCase());
		ts.add("gadde".toUpperCase());
		ts.add("Anvesh");

		System.out.println("TreeSet representation: ");
		System.out.println(ts);
		System.out.println(System.lineSeparator());

	}

}
