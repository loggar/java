package com.loggar.list.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class ListToSet {
	public void givenUsingCoreJava_whenListConvertedToSet_thenCorrect() {
		List<Integer> sourceList = Arrays.asList(0, 1, 2, 3, 4, 5);
		@SuppressWarnings("unused") Set<Integer> targetSet = new HashSet<>(sourceList);
	}

	public void givenUsingGuava_whenListConvertedToSet_thenCorrect() {
		List<Integer> sourceList = Lists.newArrayList(0, 1, 2, 3, 4, 5);
		@SuppressWarnings("unused") Set<Integer> targetSet = Sets.newHashSet(sourceList);
	}

	public void givenUsingCommonsCollections_whenListConvertedToSet_thenCorrect() {
		List<Integer> sourceList = Lists.newArrayList(0, 1, 2, 3, 4, 5);
		Set<Integer> targetSet = new HashSet<>(6);
		CollectionUtils.addAll(targetSet, sourceList);
	}

	public void givenUsingCoreJava_whenSetConvertedToList_thenCorrect() {
		Set<Integer> sourceSet = Sets.newHashSet(0, 1, 2, 3, 4, 5);
		@SuppressWarnings("unused") List<Integer> targetList = new ArrayList<>(sourceSet);
	}

	public void givenUsingGuava_whenSetConvertedToList_thenCorrect() {
		Set<Integer> sourceSet = Sets.newHashSet(0, 1, 2, 3, 4, 5);
		@SuppressWarnings("unused") List<Integer> targetList = Lists.newArrayList(sourceSet);
	}

	public void givenUsingCommonsCollections_whenSetConvertedToList_thenCorrect() {
		Set<Integer> sourceSet = Sets.newHashSet(0, 1, 2, 3, 4, 5);
		List<Integer> targetList = new ArrayList<>(6);
		CollectionUtils.addAll(targetList, sourceSet);
	}
}
