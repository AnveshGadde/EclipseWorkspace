package org.anveshgadde.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkListImple {

	public static void main(String[] args) {

		LinkedList<String> ll = new LinkedList<String>();

		ll.add("200");
		ll.add(String.valueOf(500));
		ll.add(String.valueOf(23.6));
		ll.add("Anvesh");

		Iterator<String> itr = ll.iterator();

		while (itr.hasNext()) {

			System.out.println("From iterator: " + itr.next());

		}

		for (String str : ll) {
			System.out.println("From for loop: " + str);
		}

	}

}