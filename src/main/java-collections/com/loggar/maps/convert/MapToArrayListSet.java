package com.loggar.maps.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MapToArrayListSet {
	Map<Integer, String> createMap() {
		Map<Integer, String> m = new HashMap<>();
		m.put(1, "one");
		m.put(2, "two");
		m.put(3, "three");
		m.put(4, "four");
		return m;
	}

	@Test
	public void givenUsingCoreJava_whenMapValuesConvertedToArray_thenCorrect() {
		Map<Integer, String> sourceMap = createMap();

		Collection<String> values = sourceMap.values();
		String[] targetArray = values.toArray(new String[values.size()]);

		Assert.assertTrue(targetArray.length == 4);
	}

	@Test
	public void givenUsingCoreJava_whenMapValuesConvertedToList_thenCorrect() {
		Map<Integer, String> sourceMap = createMap();

		List<String> targetList = new ArrayList<>(sourceMap.values());

		Assert.assertTrue(targetList.size() == 4);
	}

	@Test
	public void givenUsingCoreJava_whenMapValuesConvertedToS_thenCorrect() {
		Map<Integer, String> sourceMap = createMap();

		Set<String> targetSet = new HashSet<>(sourceMap.values());

		Assert.assertTrue(targetSet.size() == 4);
	}
}
