package com.loggar.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterateThroughList {
	public static void main(String[] argv) {

		// create list
		List<String> sampleList = new ArrayList<String>();

		// add 4 different values to list
		sampleList.add("eBay");
		sampleList.add("Paypal");
		sampleList.add("Google");
		sampleList.add("Yahoo");

		// iterate via "for loop"
		System.out.println("==> For Loop Example.");
		for (int i = 0; i < sampleList.size(); i++) {
			System.out.println(sampleList.get(i));
		}

		// iterate via "New way to loop"
		System.out.println("==> Advance For Loop Example..");
		for (String temp : sampleList) {
			System.out.println(temp);
		}

		// iterate via "iterator loop"
		System.out.println("==> Iterator Example...");
		Iterator<String> sampleIterator = sampleList.iterator();
		while (sampleIterator.hasNext()) {
			System.out.println(sampleIterator.next());
		}

		// iterate via "while loop"
		System.out.println("==> While Loop Example....");
		int i = 0;
		while (i < sampleList.size()) {
			System.out.println(sampleList.get(i));
			i++;
		}

		// collection stream() util: Returns a sequential Stream with this collection as
		// its source
		System.out.println("==> collection stream() util....");
		sampleList.forEach((temp) -> {
			System.out.println(temp);
		});
	}
}
