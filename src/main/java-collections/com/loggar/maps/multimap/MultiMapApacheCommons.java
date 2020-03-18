package com.loggar.maps.multimap;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.collections4.MultiMapUtils;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * @Dependency org.apache.commons commons-collections4
 */
public class MultiMapApacheCommons {
	@SuppressWarnings("unchecked")
	@Test
	public void multimap() {
		MultiMap map = new MultiValueMap();
		map.put("key1", "value1");
		map.put("key1", "value2");
		assertThat((Collection<String>) map.get("key1")).contains("value1", "value2");
	}

	@Test
	public void multivaluedmap() {
		MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
		map.put("key1", "value1");
		map.put("key1", "value2");
		map.put("key1", "value2");
		assertThat((Collection<String>) map.get("key1")).containsExactly("value1", "value2", "value2");
	}

	@Test
	public void multivaluedmap_remove_duplicateds() {
		MultiValuedMap<String, String> map = new HashSetValuedHashMap<>();
		map.put("key1", "value1");
		map.put("key1", "value1");
		assertThat((Collection<String>) map.get("key1")).containsExactly("value1");
	}

	@Test
	public void decorator_UnmodifiableMultiValuedMap() {
		MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
		map.put("key1", "value1");
		map.put("key1", "value2");
		MultiValuedMap<String, String> immutableMap = MultiMapUtils.unmodifiableMultiValuedMap(map);

		Assertions.assertThrows(UnsupportedOperationException.class, () -> immutableMap.put("key1", "value3"));
	}
}
