package com.loggar.list;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ListEqualsTestJUnit {
	@Test
	public void whenTestingForEquality_ShouldBeEqual() throws Exception {
		List<String> list1 = Arrays.asList("1", "2", "3", "4");
		List<String> list2 = Arrays.asList("1", "2", "3", "4");
		List<String> list3 = Arrays.asList("1", "2", "4", "3");

		assertTrue(list1.equals(list2));
		assertFalse(list1.equals(list3));
	}
}
