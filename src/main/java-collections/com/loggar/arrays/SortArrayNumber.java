package com.loggar.arrays;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortArrayNumber {
	int[] toSort;
	int[] sortedInts;
	int[] sortedRangeInts;

	@BeforeEach
	public void initVariables() {
		toSort = new int[] { 5, 1, 89, 255, 7, 88, 200, 123, 66 };
		sortedInts = new int[] { 1, 5, 7, 66, 88, 89, 123, 200, 255 };
		sortedRangeInts = new int[] { 5, 1, 89, 7, 88, 200, 255, 123, 66 };
	}

	@Test
	public void givenIntArray_whenUsingSort_thenSortedArray() {
		Arrays.sort(toSort);

		Assert.assertTrue(Arrays.equals(toSort, sortedInts));
	}

	@Test
	public void givenIntArray_whenUsingRangeSort_thenRangeSortedArray() {
		Arrays.sort(toSort, 3, 7);

		Assert.assertTrue(Arrays.equals(toSort, sortedRangeInts));
	}

	@Test
	public void givenIntArray_whenUsingParallelSort_thenArraySorted() {
		Arrays.parallelSort(toSort);

		Assert.assertTrue(Arrays.equals(toSort, sortedInts));
	}
}
