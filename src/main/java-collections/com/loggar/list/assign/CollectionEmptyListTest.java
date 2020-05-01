package com.loggar.list.assign;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CollectionEmptyListTest {
	@Test
	public void emptyCollectionTest() {
		List<Map<String, Object>> list = Collections.emptyList();
		assertTrue(list.isEmpty());
		assertTrue(list.size() < 1);
	}
}
