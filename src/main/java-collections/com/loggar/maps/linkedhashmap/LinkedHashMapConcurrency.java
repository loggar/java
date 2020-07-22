package com.loggar.maps.linkedhashmap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.loggar.concurrent.map.ConcurrencyMapUtil;

public class LinkedHashMapConcurrency {
	@Test
	public void givenConcurrentMap_whenSumParallel_thenCorrect() throws Exception {
		Map<String, Integer> map = Collections.synchronizedMap(new LinkedHashMap<>());
		List<Integer> sumList = ConcurrencyMapUtil.parallelSum100(map, 1000);

		assertEquals(1, sumList.stream().distinct().count());
		long resultCount = sumList.stream().filter(num -> num != 100).count();

		assertEquals(0, resultCount);
	}
}
