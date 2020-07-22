package com.loggar.list.manipulate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FlattenList {
	List<List<String>> nestedList;

	@BeforeEach
	public void before() {
		nestedList = Arrays.asList(Arrays.asList("one:one"), Arrays.asList("two:one", "two:two", "two:three"), Arrays.asList("three:one", "three:two", "three:three", "three:four"));
	}

	public <T> List<T> flattenListOfListsImperatively(List<List<T>> nestedList) {
		List<T> ls = new ArrayList<>();
		nestedList.forEach(ls::addAll);
		return ls;
	}

	@Test
	public void givenNestedList_thenFlattenImperatively() {
		List<String> ls = flattenListOfListsImperatively(nestedList);

		Assertions.assertNotNull(ls);
		Assertions.assertTrue(ls.size() == 8);
		Assert.assertThat(ls, IsIterableContainingInOrder.contains("one:one", "two:one", "two:two", "two:three", "three:one", "three:two", "three:three", "three:four"));
	}

	public <T> List<T> flattenListOfListsStream(List<List<T>> list) {
		return list.stream().flatMap(Collection::stream).collect(Collectors.toList());
	}

	@Test
	public void givenNestedList_thenFlattenFunctionally() {
		List<String> ls = flattenListOfListsStream(nestedList);

		Assertions.assertNotNull(ls);
		Assertions.assertTrue(ls.size() == 8);
	}
}
