package com.loggar.collections.split;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class SplitCollections {
	@Test
	public void whenSplitCollectionHalf_thenConverted() {
		Collection<String> animals = Arrays.asList("Dog", "Cat", "Cow", "Bird", "Moose", "Pig");
		Collection<String> result1 = new ArrayList<>();
		Collection<String> result2 = new ArrayList<>();
		AtomicInteger count = new AtomicInteger();
		int midpoint = Math.round(animals.size() / 2);

		animals.forEach(next -> {
			int index = count.getAndIncrement();
			if (index < midpoint) {
				result1.add(next);
			} else {
				result2.add(next);
			}
		});

		assertTrue(result1.equals(Arrays.asList("Dog", "Cat", "Cow")));
		assertTrue(result2.equals(Arrays.asList("Bird", "Moose", "Pig")));
	}

	@Test
	public void whenConvertStringToCollection_thenConverted() {
		String animals = "Dog, Cat, Bird, Cow";
		Collection<String> result = Arrays.asList(animals.split(", "));

		assertTrue(result.equals(Arrays.asList("Dog", "Cat", "Bird", "Cow")));
	}

	@Test
	public void whenConvertStringToMap_thenConverted() {
		String animals = "1 = Dog, 2 = Cat, 3 = Bird";

		Map<Integer, String> result = Arrays.stream(animals.split(", ")).map(next -> next.split(" = ")).collect(Collectors.toMap(entry -> Integer.parseInt(entry[0]), entry -> entry[1]));

		assertEquals(result.get(1), "Dog");
		assertEquals(result.get(2), "Cat");
		assertEquals(result.get(3), "Bird");
	}

	@Test
	public void whenConvertCollectionToStringMultipleSeparators_thenConverted() {
		String animals = "Dog. , Cat, Bird. Cow";

		Collection<String> result = Arrays.stream(animals.split("[,|.]")).map(String::trim).filter(next -> !next.isEmpty()).collect(Collectors.toList());

		assertTrue(result.equals(Arrays.asList("Dog", "Cat", "Bird", "Cow")));
	}

}
