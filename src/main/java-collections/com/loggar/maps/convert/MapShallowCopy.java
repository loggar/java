package com.loggar.maps.convert;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapShallowCopy {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(55, "John");
		map.put(22, "Apple");
		map.put(66, "Earl");
		map.put(77, "Pearl");
		map.put(12, "George");
		map.put(6, "Rocky");

		@SuppressWarnings("unused") Map<Integer, String> copiedMap = Collections.synchronizedMap(map);

	}
}
