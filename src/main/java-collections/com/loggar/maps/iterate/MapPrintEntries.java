package com.loggar.maps.iterate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class MapPrintEntries {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");

		// 1. Using an iterator
		Iterator<Entry<Integer, String>> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<Integer, String> entry = itr.next();
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		// 2. For-each loop
		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry);
		}

		// 3. Java 8 – Collection.iterator() + Iterator.forEachRemaining()
		map.entrySet().iterator().forEachRemaining(System.out::println);

		// 4. Java 8 – Collection.stream() + Stream.forEach()
		map.entrySet().stream().forEach(System.out::println);

		// Java 8 – Stream.of() + Collection.toArray() + Stream.forEach()
		Stream.of(map.entrySet().toArray()).forEach(System.out::println);

		// 5. Convert to a string
		System.out.println(map.entrySet().toString());

		// Java 8
		Stream.of(map.entrySet().toString()).forEach(System.out::println);

	}
}
