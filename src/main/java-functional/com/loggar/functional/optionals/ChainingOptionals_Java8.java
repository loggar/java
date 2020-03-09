package com.loggar.functional.optionals;

import static org.junit.Assert.assertEquals;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

public class ChainingOptionals_Java8 {
	@Test
	public void givenThreeOptionals_whenChaining_thenFirstNonEmptyIsReturned() {
		Optional<String> found = Stream.of(getEmpty(), getHello(), getBye()).filter(Optional::isPresent).map(Optional::get).findFirst();

		assertEquals(getHello(), found);
	}

	@Test
	public void givenThreeOptionals_whenChaining_thenFirstNonEmptyIsReturnedAndRestNotEvaluated() {
		Optional<String> found = Stream.<Supplier<Optional<String>>>of(this::getEmpty, this::getHello, this::getBye).map(Supplier::get).filter(Optional::isPresent).map(Optional::get).findFirst();

		assertEquals(getHello(), found);
	}

	@Test
	public void givenTwoOptionalsReturnedByOneArgMethod_whenChaining_thenFirstNonEmptyIsReturned() {
		Optional<String> found = Stream.<Supplier<Optional<String>>>of(() -> createOptional("empty"), () -> createOptional("hello")).map(Supplier::get).filter(Optional::isPresent).map(Optional::get).findFirst();

		assertEquals(createOptional("hello"), found);
	}

	@Test
	public void givenTwoEmptyOptionals_whenChaining_thenDefaultIsReturned() {
		String found = Stream.<Supplier<Optional<String>>>of(() -> createOptional("empty"), () -> createOptional("empty")).map(Supplier::get).filter(Optional::isPresent).map(Optional::get).findFirst().orElseGet(() -> "default");

		assertEquals("default", found);
	}

	private Optional<String> getEmpty() {
		return Optional.empty();
	}

	private Optional<String> getHello() {
		return Optional.of("hello");
	}

	private Optional<String> getBye() {
		return Optional.of("bye");
	}

	private Optional<String> createOptional(String input) {
		if (input == null || input == "" || input == "empty") {
			return Optional.empty();
		}
		return Optional.of(input);
	}
}
