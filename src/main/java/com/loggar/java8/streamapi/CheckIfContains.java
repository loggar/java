package com.loggar.java8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CheckIfContains {
	public static void main(String[] args) {

		int randomNo;

		// Let's create integer array with 15 values in it
		int[] intArray = new int[15];
		for (int i = 1; i <= 14; i++) {
			randomNo = (7 + (int) (Math.random() * ((95 - 7))));
			intArray[i] = randomNo;
		}

		log("Here is an array intArray[i] ==> " + Arrays.toString(intArray));
		log("\n");

		// Now let's run loop for 10 times to see if my random value is part of int[]
		// intArray
		log("============= Test1: Legacy Java7 Way =============");
		for (int j = 1; j <= 5; j++) {
			randomNo = (7 + (int) (Math.random() * ((95 - 7))));

			if (containsMethod(intArray, randomNo)) {
				log("Matched: " + randomNo + " in array intArray[i]");
			} else {
				log("No Match for: " + randomNo);
			}
		}
		log("\n");

		// this is java8 way to find if Array contains specified value.
		java8IntStreamLongStreamExample(intArray);
		java8ArraysAsListExample(intArray);

	}

	// Java7: Simple Legacy way to check if specified value is there in Array :)
	public static boolean containsMethod(int[] intArray, int matchedValue) {

		for (int isMatched : intArray) {
			if (isMatched == matchedValue) {
				return true;
			}
		}
		return false;
	}

	// Java8: IntStream -> anyMatch() and LongStream.anyMatch() Example
	public static void java8IntStreamLongStreamExample(int[] intArray) {

		// Intstream: A sequence of primitive int-valued elements supporting sequential
		// and parallel aggregate operations.
		// anyMatch() returns whether any elements of this stream match the provided
		// predicate.

		// Now let's run loop for 10 times to see if my random value is part of int[]
		// intArray

		log("============= Test2: Java8 IntStream->anyMatch() Way =============");
		for (int j = 1; j <= 5; j++) {
			int randomNo = (7 + (int) (Math.random() * ((95 - 7))));
			if (IntStream.of(intArray).anyMatch(myValue -> myValue == randomNo)) {
				log("Matched " + randomNo + " in array intArray[i]");
			} else {
				log("No Match for: " + randomNo);
			}
		}
		log("\n");

		long[] longArray = new long[15];
		for (int i = 1; i <= 14; i++) {
			long randomLongNo = (7 + (long) (Math.random() * ((95 - 7))));
			longArray[i] = randomLongNo;
		}
		log("Here is an array longArray[i] ==> " + Arrays.toString(longArray));

		log("\n============= Test3: Java8 LongStream->anyMatch() Way =============");
		for (int j = 1; j <= 5; j++) {
			long randomNo = (7 + (long) (Math.random() * ((95 - 7))));
			if (LongStream.of(longArray).anyMatch(myValue -> myValue == randomNo)) {
				log("Matched " + randomNo + " in array longArray[i]");
			} else {
				log("No Match for: " + randomNo);
			}
		}
		log("\n");

	}

	// Java8: Arrays.asList() contains() and containsAll() Example
	private static void java8ArraysAsListExample(int[] intArray) {
		String[] company = new String[] { "Facebook", "Twitter", "Google" };

		// Convert String Array to List
		List<String> list = Arrays.asList(company);

		log("============= Test4: Arrays.asList() contains() and containsAll() Example =============");
		if (list.contains("Twitter")) {
			log("Matched Found for Twitter");
		}

		if (list.contains("Twitter") || list.contains("Facebook")) {
			log("Matched Found for Twitter and Facebook");
		}

		// A and B
		if (list.containsAll(Arrays.asList("Google", "Facebook"))) {
			log("Matched Found for Google and Facebook");
		}

	}

	// Simple log utility
	private static void log(String string) {
		System.out.println(string);

	}
}
