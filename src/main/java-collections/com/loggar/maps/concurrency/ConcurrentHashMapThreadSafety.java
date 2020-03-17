package com.loggar.maps.concurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Test;

public class ConcurrentHashMapThreadSafety {
	@Test
	public void givenConcurrentMap_whenSumParallel_thenCorrect() throws Exception {
		Map<String, Integer> map = new ConcurrentHashMap<>();
		List<Integer> sumList = ConcurrencyMapUtil.parallelSum100(map, 1000);

		assertEquals(1, sumList.stream().distinct().count());
		long resultCount = sumList.stream().filter(num -> num != 100).count();

		assertEquals(0, resultCount);
	}
}
