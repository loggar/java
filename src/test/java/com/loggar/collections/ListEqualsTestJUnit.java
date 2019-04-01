package com.loggar.collections;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ListEqualsTestJUnit {
	@Test
	public void whenTestingForEquality_ShouldBeEqual() throws Exception {
		List<String> list1 = Arrays.asList("1", "2", "3", "4");
		List<String> list2 = Arrays.asList("1", "2", "3", "4");
		List<String> list3 = Arrays.asList("1", "2", "4", "3");

		assertThat(list1).isEqualTo(list2).isNotEqualTo(list3);

		assertThat(list1.equals(list2)).isTrue();
		assertThat(list1.equals(list3)).isFalse();
	}
}
