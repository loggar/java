package com.loggar.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

public class ConvertArrayToSet {
	@Test
	public void givenUsingCoreJavaV1_whenArrayConvertedToSet_thenCorrect() {
		Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
		@SuppressWarnings("unused") Set<Integer> targetSet = new HashSet<Integer>(Arrays.asList(sourceArray));
	}

	@Test
	public void givenUsingCoreJavaV2_whenArrayConvertedToSet_thenCorrect() {
		Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
		Set<Integer> targetSet = new HashSet<Integer>();
		Collections.addAll(targetSet, sourceArray);
	}

	@Test
	public void givenUsingGuava_whenArrayConvertedToSet_thenCorrect() {
		Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
		@SuppressWarnings("unused") Set<Integer> targetSet = Sets.newHashSet(sourceArray);
	}

	@Test
	public void givenUsingCommonsCollections_whenArrayConvertedToSet_thenCorrect() {
		Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
		Set<Integer> targetSet = new HashSet<>(6);
		CollectionUtils.addAll(targetSet, sourceArray);
	}

	@Test
	public void givenUsingCoreJava_whenSetConvertedToArray_thenCorrect() {
		Set<Integer> sourceSet = Sets.newHashSet(0, 1, 2, 3, 4, 5);
		@SuppressWarnings("unused") Integer[] targetArray = sourceSet.toArray(new Integer[sourceSet.size()]);
	}

	@Test
	public void givenUsingGuava_whenSetConvertedToArray_thenCorrect() {
		Set<Integer> sourceSet = Sets.newHashSet(0, 1, 2, 3, 4, 5);
		@SuppressWarnings("unused") int[] targetArray = Ints.toArray(sourceSet);
	}

	@Test
	public void givenUsingCommonsCollections_whenSetConvertedToArray_thenCorrect() {
		Set<Integer> sourceSet = Sets.newHashSet(0, 1, 2, 3, 4, 5);
		@SuppressWarnings("unused") Integer[] targetArray = sourceSet.toArray(new Integer[sourceSet.size()]);
	}
}
