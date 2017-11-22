package com.loggar.java8.streamapi;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * http://crunchify.com/in-java8-how-to-convert-array-to-stream-using-arrays-stream-and-stream-of-operations/
 * @author loggar.lee
 *
 */
public class CrunchifyArrayToStreamInJava8 {
	public static void main(String[] args) {

		// Try with Object Array
		String[] crunchifyCompany = { "Twitter", "Facebook", "Yahoo", "Google" };

		// Arrays.stream - returns a sequential Stream with the specified array as its
		// source
		Stream<String> crunchifyStream = Arrays.stream(crunchifyCompany);
		log("\n1. Arrays.stream output for Object Array:");
		crunchifyStream.forEach(company -> log(company));

		// Stream.of - returns a sequential ordered stream whose elements are the
		// specified values
		Stream<String> crunchifyStream2 = Stream.of(crunchifyCompany);
		log("\n2. Stream.of output for Object Array:");
		crunchifyStream2.forEach(company -> log(company));

		// Now try with Primitive Arrays
		double[] doubleCrunchify = { 11.1, 21.2, 31.3, 41.4, 51.5 };

		DoubleStream doubleStream = Arrays.stream(doubleCrunchify);
		log("\n1. Arrays.stream output for Primitive Arrays:");
		doubleStream.forEach(company -> System.out.println(company));

		Stream<double[]> crunchify = Stream.of(doubleCrunchify);
		// flatMapToDouble - returns an DoubleStream consisting of the results of
		// replacing each element of this stream
		// with the contents of a mapped stream produced by applying the provided
		// mapping function to each element.
		DoubleStream doubleStream2 = crunchify.flatMapToDouble(doubleArray -> Arrays.stream(doubleArray));
		log("\n2. Stream.of output for Primitive Arrays:");
		doubleStream2.forEach(company -> System.out.println(company));
	}

	private static void log(String crunchifyString) {
		System.out.println(crunchifyString);

	}
}
