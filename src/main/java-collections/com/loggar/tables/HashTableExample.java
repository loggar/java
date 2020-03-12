package com.loggar.tables;

import java.util.Hashtable;

public class HashTableExample {
	public static void main(String[] args) {
		Hashtable<Word, String> table = new Hashtable<>();

		Word word = new Word("cat");
		table.put(word, "an animal");

		String definition = table.get(word);
		System.out.println(definition);

		definition = table.remove(word);
		System.out.println(definition);
	}
}
