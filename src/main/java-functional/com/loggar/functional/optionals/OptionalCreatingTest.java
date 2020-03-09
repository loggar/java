package com.loggar.functional.optionals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.Test;

public class OptionalCreatingTest {
	@Test
	public void whenCreatesEmptyOptional_thenCorrect() {
		Optional<String> empty = Optional.empty();
		assertFalse(empty.isPresent());
	}

	@Test
	public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
		String name = "baeldung";
		Optional.of(name);
	}

	@Test
	public void givenNonNull_whenCreatesOptional_thenCorrect() {
		String name = "baeldung";
		Optional<String> opt = Optional.of(name);
		assertEquals("Optional[baeldung]", opt.toString());
	}

	@Test(expected = NullPointerException.class)
	public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
		String name = null;
		Optional<String> opt = Optional.of(name);
		System.out.println(opt);
	}

	@Test
	public void givenNonNull_whenCreatesNullable_thenCorrect() {
		String name = "baeldung";
		Optional<String> opt = Optional.ofNullable(name);
		assertEquals("Optional[baeldung]", opt.toString());
	}

	@Test
	public void givenNull_whenCreatesNullable_thenCorrect() {
		String name = null;
		Optional<String> opt = Optional.ofNullable(name);
		assertEquals("Optional.empty", opt.toString());
	}
}
