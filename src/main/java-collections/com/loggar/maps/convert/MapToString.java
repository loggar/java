package com.loggar.maps.convert;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MapToString {

	public static String convertWithIteration(Map<Integer, ?> map) {
		StringBuilder mapAsString = new StringBuilder("{");
		for (Integer key : map.keySet()) {
			mapAsString.append(key + "=" + map.get(key) + ", ");
		}
		mapAsString.delete(mapAsString.length() - 2, mapAsString.length()).append("}");
		return mapAsString.toString();
	}

	public String convertWithStream(Map<Integer, ?> map) {
		String mapAsString = map.keySet().stream().map(key -> key + "=" + map.get(key)).collect(Collectors.joining(", ", "{", "}"));
		return mapAsString;
	}

	@Test
	public void givenMap_WhenUsingIteration_ThenResultingStringIsCorrect() {
		Map<Integer, String> wordsByKey = new HashMap<>();
		wordsByKey.put(1, "one");
		wordsByKey.put(2, "two");
		wordsByKey.put(3, "three");
		wordsByKey.put(4, "four");

		String mapAsString = MapToString.convertWithIteration(wordsByKey);
		Assert.assertEquals("{1=one, 2=two, 3=three, 4=four}", mapAsString);
	}
}
