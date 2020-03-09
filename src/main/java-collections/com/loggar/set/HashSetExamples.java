package com.loggar.set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class HashSetExamples {
	@Test
	public void whenAddingElement_shouldAddElement() {
		Set<String> hashset = new HashSet<>();

		assertTrue(hashset.add("String Added"));
	}

	@Test
	public void whenCheckingForElement_shouldSearchForElement() {
		Set<String> hashsetContains = new HashSet<>();
		hashsetContains.add("String Added");

		assertTrue(hashsetContains.contains("String Added"));
	}

	@Test
	public void whenRemovingElement_shouldRemoveElement() {
		Set<String> removeFromHashSet = new HashSet<>();
		removeFromHashSet.add("String Added");

		assertTrue(removeFromHashSet.remove("String Added"));
	}

	@Test
	public void whenClearingHashSet_shouldClearHashSet() {
		Set<String> clearHashSet = new HashSet<>();
		clearHashSet.add("String Added");
		clearHashSet.clear();

		assertTrue(clearHashSet.isEmpty());
	}

	@Test
	public void whenCheckingTheSizeOfHashSet_shouldReturnThesize() {
		Set<String> hashSetSize = new HashSet<>();
		hashSetSize.add("String Added");

		assertEquals(1, hashSetSize.size());
	}

	@Test
	public void whenCheckingForEmptyHashSet_shouldCheckForEmpty() {
		Set<String> emptyHashSet = new HashSet<>();

		assertTrue(emptyHashSet.isEmpty());
	}
}
