package com.loggar.maps.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortMap {
	HashMap<Integer, String> map;

	@BeforeEach
	public void before() {
		map = new HashMap<>();
		map.put(55, "John");
		map.put(22, "Apple");
		map.put(66, "Earl");
		map.put(77, "Pearl");
		map.put(12, "George");
		map.put(6, "Rocky");
	}

	@Test
	public void givenMap_whenSortingByKeys_thenSortedMap() {
		Integer[] sortedKeys = new Integer[] { 6, 12, 22, 55, 66, 77 };

		List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<Integer, String>>() {
			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<Integer, String> entry : entries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		Assert.assertTrue(Arrays.equals(sortedMap.keySet().toArray(), sortedKeys));
	}

	@Test
	public void givenMap_whenSortingByValues_thenSortedMap() {
		String[] sortedValues = new String[] { "Apple", "Earl", "George", "John", "Pearl", "Rocky" };

		List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<Integer, String>>() {
			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<Integer, String> entry : entries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		Assert.assertTrue(Arrays.equals(sortedMap.values().toArray(), sortedValues));
	}

}
