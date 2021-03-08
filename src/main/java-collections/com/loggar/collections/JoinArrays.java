package com.loggar.collections;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class JoinArrays {
	@Test
	public void whenJoiningTwoArrays_thenJoined() {
		String[] animals1 = new String[] { "Dog", "Cat" };
		String[] animals2 = new String[] { "Bird", "Cow" };

		String[] result = Stream.concat(Arrays.stream(animals1), Arrays.stream(animals2)).toArray(String[]::new);

		assertArrayEquals(result, new String[] { "Dog", "Cat", "Bird", "Cow" });
	}

	@Test
	public void whenConvertArrayToString_thenConverted() {
		String[] animals = new String[] { "Dog", "Cat", "Bird", "Cow" };
		String result = Arrays.stream(animals).collect(Collectors.joining(", "));

		assertEquals(result, "Dog, Cat, Bird, Cow");
	}
}
