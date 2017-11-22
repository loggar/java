package com.loggar.java8.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimitiveArrayToListJava8 {
	public static void main(String[] args) {
		int randomNumber;

		// add random value to integer array

		int[] value = new int[15]; // we are adding total 15 primitive values to int[] array.
		for (int i = 1; i <= 14; i++) {
			randomNumber = (5 + (int) (Math.random() * ((100 - 5))));
			value[i] = randomNumber;
		}

		// Java8 - Stream way to convert Primitive array to List.
		// stream() returns a sequential IntStream with the specified array as its
		// source.
		// Boxed() returns a Stream consisting of the elements of this stream, each
		// boxed to an Integer.
		// collect() performs a mutable reduction operation on the elements of this
		// stream using a Collector.
		List<Integer> covertedList = Arrays.stream(value).boxed().collect(Collectors.toList());
		System.out.println("Java8 way: Using stream().boxed.collect() : " + covertedList);

		// Classic way to convert Primitive array to List
		classWaytoConvert(value);
	}

	public static void classWaytoConvert(int[] value) {

		List<Integer> intList = new ArrayList<Integer>();

		System.out.println("Classic way 1: Print intList Value via toString(): " + Arrays.toString(value));

		for (int i : value) {
			intList.add(i);
		}

		// if you want to use Iterator to print value
		System.out.println("Classic way 2: Print intList Value via Iterator: " + intList);

	}
}
