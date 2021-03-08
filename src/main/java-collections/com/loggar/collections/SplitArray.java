package com.loggar.collections;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class SplitArray {
	@Test
	public void whenSplitArrayByWordLength_thenConverted() {
		String[] animals = new String[] { "Dog", "Cat", "Bird", "Cow", "Pig", "Moose" };
		Map<Integer, List<String>> result = Arrays.stream(animals).collect(Collectors.groupingBy(String::length));

		assertTrue(result.get(3).equals(Arrays.asList("Dog", "Cat", "Cow", "Pig")));
		assertTrue(result.get(4).equals(Arrays.asList("Bird")));
		assertTrue(result.get(5).equals(Arrays.asList("Moose")));
	}

	@Test
	public void whenConvertStringToArray_thenConverted() {
		String animals = "Dog, Cat, Bird, Cow";
		String[] result = animals.split(", ");

		assertArrayEquals(result, new String[] { "Dog", "Cat", "Bird", "Cow" });
	}
}
