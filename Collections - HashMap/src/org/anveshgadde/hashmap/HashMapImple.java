package org.anveshgadde.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapImple {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		HashMap<String, Integer> hmp = new HashMap<String, Integer>();

		hmp.put("one", 1);
		hmp.put("one", 2);
		hmp.put("two", 2);
		hmp.put("three", 3);

		System.out.println("Through HashMap: ");

		for (Map.Entry me : hmp.entrySet()) {
			System.out.println("Through Map: " + me.getKey() + " : " + me.getValue());
		}

		System.out.println("HashMap ended here............");
		System.out.print(System.lineSeparator());

		LinkedHashMap<String, Integer> lhmp = new LinkedHashMap<String, Integer>();

		lhmp.put("one", 1);
		lhmp.put("one", 2);
		lhmp.put(null, 2);
		lhmp.put("three",0);

		System.out.println("Through LinkedHashMap: ");

		for (Map.Entry sme : lhmp.entrySet()) {
			System.out.println("Through Map: " + sme.getKey() + " : " + sme.getValue());
		}

		System.out.println("LinkedHashMap ended here............");
		System.out.print(System.lineSeparator());

		TreeMap<String, Integer> tmp = new TreeMap<String, Integer>();

		tmp.put("one", 1);
		tmp.put("one", 2);
		tmp.put("two", 2);
		tmp.put("three", 3);

		System.out.println("Through TreeMap: ");

		for (Map.Entry tme : tmp.entrySet()) {
			System.out.println("Through Map: " + tme.getKey() + " : " + tme.getValue());
		}
	}
}
