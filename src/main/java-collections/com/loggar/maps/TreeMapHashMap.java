package com.loggar.maps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TreeMapHashMap {
	// we can't assume any order while iterating over keys and values of a HashMap:
	@Test
	public void whenInsertObjectsHashMap_thenRandomOrder() {
		Map<Integer, String> hashmap = new HashMap<>();
		hashmap.put(3, "TreeMap");
		hashmap.put(2, "vs");
		hashmap.put(1, "HashMap");

		assertThat(hashmap.keySet(), containsInAnyOrder(1, 2, 3));
	}

	// However, items in a TreeMap are sorted according to their natural order.
	@Test
	public void whenInsertObjectsTreeMap_thenNaturalOrder() {
		Map<Integer, String> treemap = new TreeMap<>();
		treemap.put(3, "TreeMap");
		treemap.put(2, "vs");
		treemap.put(1, "HashMap");

		assertThat(treemap.keySet(), contains(1, 2, 3));
	}

	// HashMap allows storing at most one null key and many null values.
	@Test
	public void whenInsertNullInHashMap_thenInsertsNull() {
		Map<Integer, String> hashmap = new HashMap<>();
		hashmap.put(null, null);

		assertNull(hashmap.get(null));
	}

	// However, TreeMap doesn't allow a null key but may contain many null values.
	@Test
	public void whenInsertNullInTreeMap_thenException() {
		Map<Integer, String> treemap = new TreeMap<>();

		Assertions.assertThrows(NullPointerException.class, () -> {
			treemap.put(null, "NullPointerException");
		});
	}

	// Both TreeMap and HashMap don't support duplicate keys. If added, it overrides the previous element (without an error or an exception):
	@Test
	public void givenHashMapAndTreeMap_whenputDuplicates_thenOnlyUnique() {
		Map<Integer, String> treeMap = new HashMap<>();
		treeMap.put(1, "Baeldung");
		treeMap.put(1, "Baeldung");

		assertTrue(treeMap.size() == 1);

		Map<Integer, String> treeMap2 = new TreeMap<>();
		treeMap2.put(1, "Baeldung");
		treeMap2.put(1, "Baeldung");

		assertTrue(treeMap2.size() == 1);
	}

	// Fail-Fast Iterators
	// The Iterator throws a ConcurrentModificationException if the Map gets modified in any way and at any time once the iterator has been created.
	// Additionally, we can use the iterator’s remove method to alter the Map during iteration.
	@Test
	public void whenModifyMapDuringIteration_thenThrowExecption() {
		Map<Integer, String> hashmap = new HashMap<>();
		hashmap.put(1, "One");
		hashmap.put(2, "Two");

		Executable executable = () -> hashmap.forEach((key, value) -> hashmap.remove(1));

		assertThrows(ConcurrentModificationException.class, executable);
	}
}
