package com.loggar.arrays;

import java.util.TreeSet;

public class UnionTwoArraysWithCollection {
	public static void main(String[] args) {
		Integer[] arrayOne = { 4, 11, 2, 1, 3, 3, 5, 7 };
		Integer[] arrayTwo = { 5, 2, 3, 15, 1, 0, 9 };
		Integer[] union = findUnion(arrayOne, arrayTwo);

		System.out.println("Union of Two Arrays: ");
		for (Integer entry : union) {
			System.out.print(entry + " ");
		}
	}

	public static Integer[] findUnion(Integer[] arrayOne, Integer[] arrayTwo) {
		TreeSet<Integer> hashedArray = new TreeSet<Integer>();
		for (Integer entry : arrayOne) {
			hashedArray.add(entry);
		}

		for (Integer entry : arrayTwo) {
			hashedArray.add(entry);
		}

		return hashedArray.toArray(new Integer[0]);
	}
}
