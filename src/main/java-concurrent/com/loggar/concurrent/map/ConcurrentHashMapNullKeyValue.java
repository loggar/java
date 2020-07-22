package com.loggar.concurrent.map;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConcurrentHashMapNullKeyValue {
	Map<String, Object> concurrentMap = new ConcurrentHashMap<>();

	@Test
	public void givenConcurrentHashMap_whenPutWithNullKey_thenThrowsNPE() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			concurrentMap.put(null, new Object());
		});
	}

	@Test
	public void givenConcurrentHashMap_whenPutNullValue_thenThrowsNPE() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			concurrentMap.put("test", null);
		});
	}

	// However, for compute and merge actions, the computed value can be null, which indicates the key-value mapping is removed if present or remains absent if previously absent.
	@Test
	public void givenKeyPresent_whenComputeRemappingNull_thenMappingRemoved() {
		Object oldValue = new Object();
		concurrentMap.put("test", oldValue);
		concurrentMap.compute("test", (s, o) -> null);

		assertNull(concurrentMap.get("test"));
	}
}
