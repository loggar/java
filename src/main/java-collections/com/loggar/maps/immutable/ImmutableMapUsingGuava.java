package com.loggar.maps.immutable;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableMap;

public class ImmutableMapUsingGuava {
	@SuppressWarnings("deprecation")
	@Test
	public void guava_immutable_map_copyOf() {
		Map<String, String> mutableMap = new HashMap<>();
		mutableMap.put("USA", "North America");

		ImmutableMap<String, String> immutableMap = ImmutableMap.copyOf(mutableMap);
		Assertions.assertTrue(immutableMap.containsKey("USA"));

		Assertions.assertThrows(UnsupportedOperationException.class, () -> immutableMap.put("Canada", "North America"));

		mutableMap.remove("USA");
		Assertions.assertTrue(immutableMap.containsKey("USA"));

		mutableMap.put("Mexico", "North America");
		Assertions.assertFalse(immutableMap.containsKey("Mexico"));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void guava_immutable_map_build() {
		Map<String, String> mutableMap = new HashMap<>();
		mutableMap.put("USA", "North America");

		ImmutableMap<String, String> immutableMap = ImmutableMap.<String, String>builder().putAll(mutableMap).put("Costa Rica", "North America").build();
		Assertions.assertTrue(immutableMap.containsKey("USA"));
		Assertions.assertTrue(immutableMap.containsKey("Costa Rica"));

		Assertions.assertThrows(UnsupportedOperationException.class, () -> immutableMap.put("Canada", "North America"));

		mutableMap.remove("USA");
		Assertions.assertTrue(immutableMap.containsKey("USA"));

		mutableMap.put("Mexico", "North America");
		Assertions.assertFalse(immutableMap.containsKey("Mexico"));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void guava_immutable_map_of() {
		ImmutableMap<String, String> immutableMap = ImmutableMap.of("USA", "North America", "Costa Rica", "North America");
		Assertions.assertTrue(immutableMap.containsKey("USA"));
		Assertions.assertTrue(immutableMap.containsKey("Costa Rica"));

		Assertions.assertThrows(UnsupportedOperationException.class, () -> immutableMap.put("Canada", "North America"));
	}
}
