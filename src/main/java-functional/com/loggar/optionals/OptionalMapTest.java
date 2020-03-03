package com.loggar.optionals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class OptionalMapTest {
	@Test
	public void givenOptional_whenMapWorks_thenCorrect() {
		List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
		Optional<List<String>> listOptional = Optional.of(companyNames);

		int size = listOptional.map(List::size).orElse(0);
		assertEquals(6, size);
	}

	@Test
	public void givenOptional_whenMapWorks_thenCorrect2() {
		String name = "baeldung";
		Optional<String> nameOptional = Optional.of(name);

		int len = nameOptional.map(String::length).orElse(0);
		assertEquals(8, len);
	}

	@Test
	public void givenOptional_whenMapWorksWithFilter_thenCorrect() {
		String password = " password ";
		Optional<String> passOpt = Optional.of(password);
		boolean correctPassword = passOpt.filter(pass -> pass.equals("password")).isPresent();
		assertFalse(correctPassword);

		correctPassword = passOpt.map(String::trim).filter(pass -> pass.equals("password")).isPresent();
		assertTrue(correctPassword);
	}
}
