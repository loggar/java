package com.loggar.list;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class ListEqualsTestAssertJ {
	@Test
	public void whenTestingForEquality_ShouldBeEqual() throws Exception {
		List<String> list1 = Arrays.asList("1", "2", "3", "4");
		List<String> list2 = Arrays.asList("1", "2", "3", "4");
		List<String> list3 = Arrays.asList("1", "2", "4", "3");

		assertThat(list1).isSameAs(list1);
		assertThat(list1).isEqualTo(list2);
		assertThat(list1).isNotEqualTo(list3);
	}
}
