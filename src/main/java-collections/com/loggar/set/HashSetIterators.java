package com.loggar.set;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashSetIterators {
	// random iteration
	@Test
	public void whenIteratingHashSet_shouldIterateHashSet() {
		Set<String> hashset = new HashSet<>();
		hashset.add("First");
		hashset.add("Second");
		hashset.add("Third");
		Iterator<String> itr = hashset.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	// If the set is modified at any time after the iterator is created in any way except through the iterator's own remove method, the Iterator throws a ConcurrentModificationException.
	@Test
	public void whenModifyingHashSetWhileIterating_shouldThrowException() {
		Set<String> hashset = new HashSet<>();
		hashset.add("First");
		hashset.add("Second");
		hashset.add("Third");
		Iterator<String> itr = hashset.iterator();

		Assertions.assertThrows(ConcurrentModificationException.class, () -> {
			while (itr.hasNext()) {
				itr.next();
				hashset.remove("Second");
			}
		});

	}

	// Alternatively, had we used the iterator's remove method, then we wouldn't have encountered the exception:
	@Test
	public void whenRemovingElementUsingIterator_shouldRemoveElement() {
		Set<String> hashset = new HashSet<>();
		hashset.add("First");
		hashset.add("Second");
		hashset.add("Third");
		Iterator<String> itr = hashset.iterator();
		while (itr.hasNext()) {
			String element = itr.next();
			if (element.equals("Second"))
				itr.remove();
		}

		assertEquals(2, hashset.size());
	}

}
