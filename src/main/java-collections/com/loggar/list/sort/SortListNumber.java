package com.loggar.list.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.primitives.Ints;

public class SortListNumber {
	int[] toSort;
	int[] sortedInts;

	@BeforeEach
	public void initVariables() {
		toSort = new int[] { 5, 1, 89, 255, 7, 88, 200, 123, 66 };
		sortedInts = new int[] { 1, 5, 7, 66, 88, 89, 123, 200, 255 };
	}

	@Test
	public void givenList_whenUsingSort_thenSortedList() {
		List<Integer> toSortList = Ints.asList(toSort);
		Collections.sort(toSortList);

		Assert.assertTrue(Arrays.equals(toSortList.toArray(), ArrayUtils.toObject(sortedInts)));
	}
}
