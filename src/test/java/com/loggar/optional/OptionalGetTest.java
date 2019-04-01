package com.loggar.optional;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;

public class OptionalGetTest {
	@Test
	public void givenOptional_whenGetsValue_thenCorrect() {
		Optional<String> opt = Optional.of("baeldung");
		String name = opt.get();

		assertEquals("baeldung", name);
	}

	@Test(expected = NoSuchElementException.class)
	public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
		Optional<String> opt = Optional.ofNullable(null);
		String name = opt.get();
		System.out.println(name);
	}
}
