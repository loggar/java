package com.loggar.list.search;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FindMinMaxNumber {
	@Test
	public void whenListIsOfIntegerThenMaxCanBeDoneUsingIntegerComparator() {
		// given
		List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
		Integer expectedResult = 89;

		// then
		Integer max = listOfIntegers.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);

		Assert.assertEquals("Should be 89", expectedResult, max);
	}
}
