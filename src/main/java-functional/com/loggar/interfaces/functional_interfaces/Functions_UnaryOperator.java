package com.loggar.interfaces.functional_interfaces;

import static org.junit.Assert.assertTrue;

import java.util.function.UnaryOperator;

import org.junit.jupiter.api.Test;

public class Functions_UnaryOperator {

	@Test
	public void unary_operator() {
		// Here, the expected input and return type are exactly same.
		// Hence we didn't use Function, but we are using a specialized sub-class

		UnaryOperator<String> toLowerUsingUnary = (s) -> s.toLowerCase();
		assertTrue(toLowerUsingUnary.apply("ABC").equals("abc"));

	}
}
