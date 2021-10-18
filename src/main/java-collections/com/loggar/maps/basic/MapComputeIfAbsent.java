package com.loggar.maps.basic;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapComputeIfAbsent {
	@Test
	public void computeIfAbsentKeyExist() {
		Map<String, Integer> stringLength = new HashMap<>();
		stringLength.put("John", 5);
		assertEquals((long) stringLength.computeIfAbsent("John", s -> s.length()), 5);
	}

	@Test
	public void computeIfAbsentKeyNotExist() {
		Map<String, Integer> stringLength = new HashMap<>();
		assertEquals(stringLength.computeIfAbsent("John", s -> null), null);
		assertNull(stringLength.get("John"));
	}
}
