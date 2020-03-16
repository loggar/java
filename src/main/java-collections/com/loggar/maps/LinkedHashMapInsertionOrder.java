package com.loggar.maps;

import java.util.LinkedHashMap;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedHashMapInsertionOrder {
	@Test
	public void givenLinkedHashMap_whenGetsOrderedKeyset_thenCorrect() {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(1, null);
		map.put(2, null);
		map.put(3, null);
		map.put(4, null);
		map.put(5, null);

		Set<Integer> keys = map.keySet();
		Integer[] arr = keys.toArray(new Integer[0]);

		for (int i = 0; i < arr.length; i++) {
			Assertions.assertEquals(new Integer(i + 1), arr[i]);
		}
	}
}
