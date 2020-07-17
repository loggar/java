package com.loggar.concurrent.list;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.jupiter.api.Test;

public class CopyOnWriteArrayListTest {
	// we can iterate over the list in a safe way, even when concurrent modification is happening

	@Test
	public void iterateTest() {
		// Iterating Over CopyOnWriteArrayList While Inserting

		CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[] { 1, 3, 5, 8 });

		Iterator<Integer> iterator = numbers.iterator();

		// After the Iterator is created, we are adding a new element to the numbers list:
		numbers.add(10);

		// when we create an iterator for the CopyOnWriteArrayList, we get an immutable snapshot of the data in the list at the time iterator() was called.
		List<Integer> result = new LinkedList<>();
		iterator.forEachRemaining(result::add);

		assertThat(result).containsOnly(1, 3, 5, 8);

		// Subsequent iteration using newly created Iterator will also return the number 10 that was added:
		Iterator<Integer> iterator2 = numbers.iterator();
		List<Integer> result2 = new LinkedList<>();
		iterator2.forEachRemaining(result2::add);

		assertThat(result2).containsOnly(1, 3, 5, 8, 10);

	}
}
