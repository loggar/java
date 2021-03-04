package com.loggar.concurrent.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListConcurrency {
	public static void list1() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		for (String s : list) {
			if (s.equals("B")) {
				list.remove(s); // Exception in thread "main" java.util.ConcurrentModificationException
			}
		}
	}

	/**
	 * Iterator can be used to solve this problem. Iterators allow the caller to remove elements from the underlying collection during the iteration.
	 */
	public static void list2() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");

		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String str = iter.next();
			if (str.equals("B")) {
				iter.remove();
			}
		}
	}

	/**
	 * Instead of ArrayList, CopyOnWriteArrayList can be used to solve the problem. CopyOnWriteArrayList is a thread-safe variant of ArrayList in which all mutative operations (add, set, and so on) are implemented by making a fresh copy of the underlying
	 * array.
	 */
	public static void list3() {
		List<String> list = new CopyOnWriteArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");

		for (String s : list) {
			if (s.equals("B")) {
				list.remove(s);
			}
		}
	}
}
