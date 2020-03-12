package com.loggar.tables;

import java.util.Hashtable;

public class HashTableJava8 {
	Hashtable<Word, String> table = new Hashtable<Word, String>();
	Word cat = new Word("cat");

	Hashtable<String, Integer> table2 = new Hashtable<String, Integer>();
	String[] animals = { "cat", "dog", "dog", "cat", "bird", "mouse", "mouse" };

	public static void main(String[] args) {
		HashTableJava8 hashTableJava8 = new HashTableJava8();
		hashTableJava8.before();
		hashTableJava8.getOrDefault();
		hashTableJava8.putIfAbsent();
		hashTableJava8.remove();
		hashTableJava8.replace();
		hashTableJava8.computeIfAbsent();
		hashTableJava8.computeIfPresent();
		hashTableJava8.compute();
		hashTableJava8.merge();
		hashTableJava8.foreach();
		hashTableJava8.replaceAll();

	}

	public void before() {
		table.put(cat, "an animal");
		table.put(new Word("dog"), "another animal");
		table.put(new Word("eagle"), "only can fly");
	}

	public void getOrDefault() {
		Word key = new Word("lion");
		String definition;

		if (table.containsKey(key)) {
			definition = table.get(key);
		} else {
			definition = "not found";
		}

		System.out.println(definition);
		System.out.println(definition = table.getOrDefault(key, "not found"));
	}

	public void putIfAbsent() {
		String definition = "this is a cat";

		if (!table.containsKey(new Word("cat"))) {
			table.put(new Word("cat"), definition);
		}

		String result = table.putIfAbsent(new Word("cat"), definition);
		System.out.println(result);
	}

	public void remove() {
		// befor java 8
		// if (table.get(new Word("cat")).equals("an animal")) {
		// String value = table.remove(new Word("cat"));
		// }

		boolean result = table.remove(new Word("cat"), "an animal");
		System.out.println(result);
	}

	public void replace() {
		// update eagle's definition if only its old definition is "only can fly"
		String definition = "new definition";

		if (table.containsKey(new Word("eagle")) && table.get(new Word("eagle")).equals("only can fly")) {
			String value = table.put(new Word("eagle"), definition);
			System.out.println(value);
		}

		boolean rep = table.replace(new Word("eagle"), "only can fly", definition);
		System.out.println(rep);
	}

	public void computeIfAbsent() {
		if (!table.containsKey(cat)) {
			String definition = "an animal2"; // note that calculations take place inside if block
			String value = table.put(new Word("cat"), definition);
			System.out.println(value);
		}

		String value = table.computeIfAbsent(new Word("cat"), key -> "an animal");
		System.out.println(value);
	}

	public void computeIfPresent() {
		if (table.containsKey(cat)) {
			String concatination = cat.getName() + " - " + table.get(cat);
			String value = table.put(cat, concatination);
			System.out.println(value);
		}

		String value = table.computeIfPresent(cat, (k, v) -> k.getName() + " - " + v);
		System.out.println(value);
	}

	public void compute() {
		for (String animal : animals) {
			table2.compute(animal, (key, value) -> (value == null ? 1 : value + 1));
		}

		System.out.println(table2);
	}

	public void merge() {
		for (String animal : animals) {
			table2.merge(animal, 1, (oldValue, value) -> (oldValue + value));
		}

		System.out.println(table2);
	}

	public void foreach() {
		table.forEach((k, v) -> System.out.println(k.getName() + " - " + v));
	}

	public void replaceAll() {
		table.replaceAll((k, v) -> k.getName() + " - " + v);
	}
}
