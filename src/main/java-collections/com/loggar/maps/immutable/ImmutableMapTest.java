package com.loggar.maps.immutable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImmutableMapTest {
	@Test
	public void collections_unmodifiable_map() {
		Map<String, String> mutableMap = new HashMap<>();
		mutableMap.put("USA", "North America");

		Map<String, String> unmodifiableMap = Collections.unmodifiableMap(mutableMap);
		Assertions.assertThrows(UnsupportedOperationException.class, () -> unmodifiableMap.put("Canada", "North America"));
	}

}
