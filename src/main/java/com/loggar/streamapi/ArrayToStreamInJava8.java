package com.loggar.streamapi;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ArrayToStreamInJava8 {
	public static void main(String[] args) {

		// Try with Object Array
		String[] company = { "Twitter", "Facebook", "Yahoo", "Google" };

		// Arrays.stream - returns a sequential Stream with the specified array as its
		// source
		Stream<String> stream = Arrays.stream(company);
		System.out.println("\n1. Arrays.stream output for Object Array:");
		stream.forEach(c -> System.out.println(c));

		// Stream.of - returns a sequential ordered stream whose elements are the
		// specified values
		Stream<String> stream2 = Stream.of(company);
		System.out.println("\n2. Stream.of output for Object Array:");
		stream2.forEach(c -> System.out.println(c));

		// Now try with Primitive Arrays
		double[] arrDouble = { 11.1, 21.2, 31.3, 41.4, 51.5 };

		DoubleStream doubleStream = Arrays.stream(arrDouble);
		System.out.println("\n1. Arrays.stream output for Primitive Arrays:");
		doubleStream.forEach(c -> System.out.println(c));

		Stream<double[]> streamDouble = Stream.of(arrDouble);
		// flatMapToDouble - returns an DoubleStream consisting of the results of
		// replacing each element of this stream
		// with the contents of a mapped stream produced by applying the provided
		// mapping function to each element.
		DoubleStream doubleStream2 = streamDouble.flatMapToDouble(doubleArray -> Arrays.stream(doubleArray));
		System.out.println("\n2. Stream.of output for Primitive Arrays:");
		doubleStream2.forEach(c -> System.out.println(c));
	}
}
