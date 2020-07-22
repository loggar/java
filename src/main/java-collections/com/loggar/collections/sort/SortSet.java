package com.loggar.collections.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.primitives.Ints;

public class SortSet {
	int[] toSort;

	@BeforeEach
	public void initVariables() {
		toSort = new int[] { 5, 1, 89, 255, 7, 88, 200, 123, 66 };
	}

	@Test
	public void givenSet_whenUsingSort_thenSortedSet() {
		Set<Integer> integersSet = new LinkedHashSet<>(Ints.asList(toSort));
		Set<Integer> descSortedIntegersSet = new LinkedHashSet<>(Arrays.asList(new Integer[] { 255, 200, 123, 89, 88, 66, 7, 5, 1 }));

		List<Integer> list = new ArrayList<Integer>(integersSet);
		Collections.sort(list, (i1, i2) -> {
			return i2 - i1;
		});
		integersSet = new LinkedHashSet<>(list);

		Assert.assertTrue(Arrays.equals(integersSet.toArray(), descSortedIntegersSet.toArray()));
	}
}
