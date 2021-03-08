package com.loggar.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class JoinCollections {
	@Test
	public void whenJoiningTwoCollectionsWithFilter_thenJoined() {
		Collection<String> collection1 = Arrays.asList("Dog", "Cat");
		Collection<String> collection2 = Arrays.asList("Bird", "Cow", "Moose");

		Collection<String> result = Stream.concat(collection1.stream(), collection2.stream()).filter(e -> e.length() == 3).collect(Collectors.toList());

		assertTrue(result.equals(Arrays.asList("Dog", "Cat", "Cow")));
	}

	@Test
	public void whenConvertCollectionToString_thenConverted() {
		Collection<String> animals = Arrays.asList("Dog", "Cat", "Bird", "Cow");
		String result = animals.stream().collect(Collectors.joining(", "));

		assertEquals(result, "Dog, Cat, Bird, Cow");
	}

	@Test
	public void whenConvertMapToString_thenConverted() {
		Map<Integer, String> animals = new HashMap<>();
		animals.put(1, "Dog");
		animals.put(2, "Cat");
		animals.put(3, "Cow");

		String result = animals.entrySet().stream().map(entry -> entry.getKey() + " = " + entry.getValue()).collect(Collectors.joining(", "));

		assertEquals(result, "1 = Dog, 2 = Cat, 3 = Cow");
	}

	@Test
	public void whenConvertNestedCollectionToString_thenConverted() {
		Collection<List<String>> nested = new ArrayList<>();
		nested.add(Arrays.asList("Dog", "Cat"));
		nested.add(Arrays.asList("Cow", "Pig"));

		String result = nested.stream().map(nextList -> nextList.stream().collect(Collectors.joining("-"))).collect(Collectors.joining("; "));

		assertEquals(result, "Dog-Cat; Cow-Pig");
	}

	@Test
	public void whenConvertCollectionToStringAndSkipNull_thenConverted() {
		Collection<String> animals = Arrays.asList("Dog", "Cat", null, "Moose");
		String result = animals.stream().filter(Objects::nonNull).collect(Collectors.joining(", "));

		assertEquals(result, "Dog, Cat, Moose");
	}
}
