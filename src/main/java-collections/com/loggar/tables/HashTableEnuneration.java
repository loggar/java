package com.loggar.tables;

import java.util.Hashtable;
import java.util.Iterator;

public class HashTableEnuneration {
	public static void main(String[] args) {
		// Fail-fast iteration means that if a Hashtable is modified after its Iterator is created, then the ConcurrentModificationException will be thrown.

		Hashtable<Word, String> table = new Hashtable<Word, String>();
		table.put(new Word("cat"), "an animal");
		table.put(new Word("dog"), "another animal");

		Iterator<Word> it = table.keySet().iterator();
		table.remove(new Word("dog"));

		while (it.hasNext()) {
			Word key = it.next();
			System.out.println(key);
		}

		// Exception in thread "main" java.util.ConcurrentModificationException
		// at java.util.Hashtable$Enumerator.next(Hashtable.java:1387)
		// at com.loggar.tables.HashTableFailFast.main(HashTableFailFast.java:18)
	}
}
