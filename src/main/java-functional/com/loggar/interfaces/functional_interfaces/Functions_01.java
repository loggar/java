package com.loggar.interfaces.functional_interfaces;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

/**
 * Usage of java.util.Function
 * 
 */
public class Functions_01 {
	/*
	 * @FunctionalInterface public interface Function<T, R> { R apply(T t); }
	 */
	
	@Test
	public void test1() {
		/*
		 * A Function is a functional interface whose sole purpose is to return any
		 * result by working on a single input argument. It accepts an argument of type
		 * T and returns a result of type R, by applying specified logic on the input
		 * via the apply method. The interface definition shown here:
		 */

		// convert centigrade to fahrenheit
		Function<Integer, Double> centigradeToFahrenheitInt = x -> new Double((x * 9 / 5) + 32);

		// String to an integer
		Function<String, Integer> stringToInt = x -> Integer.valueOf(x);

		// tests
		System.out.println("Centigrade to Fahrenheit: " + centigradeToFahrenheitInt.apply(10));
		System.out.println("String to Int: " + stringToInt.apply("4"));
	}

}
