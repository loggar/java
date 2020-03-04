package com.loggar.list;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListEqualsTestTestNG {
	@Test
	public void whenTestingForEquality_ShouldBeEqual() throws Exception {
		List<String> list1 = Arrays.asList("1", "2", "3", "4");
		List<String> list2 = Arrays.asList("1", "2", "3", "4");
		List<String> list3 = Arrays.asList("1", "2", "4", "3");

		Assert.assertEquals(list1, list2);
		Assert.assertNotSame(list1, list2);
		Assert.assertNotEquals(list1, list3);
	}
}
