package org.anveshgadde.priorityqueue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PQImple {

	public static void main(String[] args) {

		PriorityQueue<String> pq = new PriorityQueue<String>();

		pq.add("Anvesh");
		pq.add("Kumar");
		pq.add("Gadde");

		System.out.println("Priority Queue peek element: " + pq.peek());

		Iterator<String> itr = pq.iterator();

		System.out.println("PriorityQueue elements are: ");

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		pq.remove();
		pq.poll();

		System.out.println("Line separator appended: " + System.lineSeparator());

		Iterator<String> itr2 = pq.iterator();

		System.out.println("PriorityQueue elements after removal are: ");

		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}

	}

}
