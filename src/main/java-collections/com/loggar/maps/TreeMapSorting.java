package com.loggar.maps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class TreeMapSorting {
	// By default, TreeMap sorts all its entries according to their natural ordering. For an integer, this would mean ascending order and for strings, alphabetical order.
	@Test
	public void givenTreeMap_whenOrdersEntriesNaturally_thenCorrect() {
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(3, "val");
		map.put(2, "val");
		map.put(1, "val");
		map.put(5, "val");
		map.put(4, "val");

		assertEquals("[1, 2, 3, 4, 5]", map.keySet().toString());
	}

	// When we use strings, they will be sorted in their natural order, i.e. alphabetically:
	@Test
	public void givenTreeMap_whenOrdersEntriesNaturally_thenCorrect2() {
		TreeMap<String, String> map = new TreeMap<>();
		map.put("c", "val");
		map.put("b", "val");
		map.put("a", "val");
		map.put("e", "val");
		map.put("d", "val");

		assertEquals("[a, b, c, d, e]", map.keySet().toString());
	}

	// If we're not satisfied with the natural ordering of TreeMap, we can also define our own rule for ordering by means of a comparator during construction of a tree map.
	// In the example below, we want the integer keys to be ordered in descending order:
	// A hash map does not guarantee the order of keys stored and specifically does not guarantee that this order will remain the same over time, but a tree map guarantees that the keys will always be sorted according to the specified order.
	@Test
	public void givenTreeMap_whenOrdersEntriesByComparator_thenCorrect() {
		TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
		map.put(3, "val");
		map.put(2, "val");
		map.put(1, "val");
		map.put(5, "val");
		map.put(4, "val");

		assertEquals("[5, 4, 3, 2, 1]", map.keySet().toString());
	}

	// We now know that TreeMap stores all its entries in sorted order. Because of this attribute of tree maps, we can perform queries like; find “largest”, find “smallest”, find all keys less than or greater than a certain value, etc.
	// The code below only covers a small percentage of these cases:
	@Test
	public void givenTreeMap_whenPerformsQueries_thenCorrect() {
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(3, "val");
		map.put(2, "val");
		map.put(1, "val");
		map.put(5, "val");
		map.put(4, "val");

		Integer highestKey = map.lastKey();
		Integer lowestKey = map.firstKey();
		Set<Integer> keysLessThan3 = map.headMap(3).keySet();
		Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();

		assertEquals(new Integer(5), highestKey);
		assertEquals(new Integer(1), lowestKey);
		assertEquals("[1, 2]", keysLessThan3.toString());
		assertEquals("[3, 4, 5]", keysGreaterThanEqTo3.toString());
	}

}
