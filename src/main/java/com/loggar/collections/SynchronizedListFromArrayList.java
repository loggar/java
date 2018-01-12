package com.loggar.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynchronizedListFromArrayList {
	public static void main(String[] args) {

		// ********************** synchronizedList ************************
		ArrayList<String> arrayList = new ArrayList<String>();

		// populate the arrayList
		arrayList.add("eBay");
		arrayList.add("Paypal");
		arrayList.add("Google");
		arrayList.add("Yahoo");

		// Returns a synchronized (thread-safe) list backed by the specified
		// list. In order to guarantee serial access, it is critical that all
		// access to the backing list is accomplished through the returned list.
		List<String> synchronizedList = Collections.synchronizedList(arrayList);

		System.out.println("synchronizedList conatins : " + synchronizedList);

		// ********************** synchronizedMap ************************
		Map<String, String> map = new HashMap<String, String>();

		// populate the map
		map.put("1", "eBay");
		map.put("2", "Paypal");
		map.put("3", "Google");
		map.put("4", "Yahoo");

		// create a synchronized map
		Map<String, String> synchronizedMap = Collections.synchronizedMap(map);

		System.out.println("synchronizedMap contains : " + synchronizedMap);
	}
}
