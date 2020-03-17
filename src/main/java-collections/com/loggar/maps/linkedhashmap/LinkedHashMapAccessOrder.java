package com.loggar.maps.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedHashMapAccessOrder {
	@Test
	public void givenLinkedHashMap_whenAccessOrderWorks_thenCorrect() {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, .75f, true);
		map.put(1, null);
		map.put(2, null);
		map.put(3, null);
		map.put(4, null);
		map.put(5, null);

		Set<Integer> keys = map.keySet();
		Assertions.assertEquals("[1, 2, 3, 4, 5]", keys.toString());

		map.get(4);
		Assertions.assertEquals("[1, 2, 3, 5, 4]", keys.toString());

		map.get(1);
		Assertions.assertEquals("[2, 3, 5, 4, 1]", keys.toString());

		map.get(3);
		Assertions.assertEquals("[2, 5, 4, 1, 3]", keys.toString());
	}
}
