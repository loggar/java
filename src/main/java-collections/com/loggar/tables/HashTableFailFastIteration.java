package com.loggar.tables;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableFailFastIteration {
	public static void main(String[] args) {
		// Enumeration in a Hashtable is not fail-fast.
		// It is safe if hashtable is modified after create enumeration from the hashtable.

		Hashtable<Word, String> table = new Hashtable<Word, String>();
		table.put(new Word("cat"), "an animal");
		table.put(new Word("dog"), "another animal");

		Enumeration<Word> enumKey = table.keys();
		table.remove(new Word("dog"));

		while (enumKey.hasMoreElements()) {
			Word key = enumKey.nextElement();
			System.out.println(key);
		}
	}
}
