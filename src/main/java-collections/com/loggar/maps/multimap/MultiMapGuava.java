package com.loggar.maps.multimap;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;

/**
 * 
 * @Dependency com.google.guava guava
 */
public class MultiMapGuava {
	@Test
	public void multimap_create() {
		Multimap<String, String> map = ArrayListMultimap.create();
		map.put("key1", "value2");
		map.put("key1", "value1");
		assertThat((Collection<String>) map.get("key1")).containsExactly("value2", "value1");

		// As always, we should prefer the immutable implementations of the Multimap interface:
		// com.google.common.collect.ImmutableListMultimap and com.google.common.collect.ImmutableSetMultimap.
	}

	@Test
	public void linkedHashMultimap() {
		Multimap<String, String> map = LinkedHashMultimap.create();
		map.put("key1", "value3");
		map.put("key1", "value1");
		map.put("key1", "value2");
		assertThat((Collection<String>) map.get("key1")).containsExactly("value3", "value1", "value2");
	}

	@Test
	public void treeMultimap() {
		Multimap<String, String> map = TreeMultimap.create();
		map.put("key1", "value3");
		map.put("key1", "value1");
		map.put("key1", "value2");
		assertThat((Collection<String>) map.get("key1")).containsExactly("value1", "value2", "value3");
	}

}
