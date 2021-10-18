package com.loggar.maps.basic;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.loggar.concurrent.map.ConcurrencyMapUtil;

public class HashMapNotThreadSafe {
	@Test
	public void givenHashMap_whenSumParallel_thenError() throws Exception {
		Map<String, Integer> map = new HashMap<>();
		List<Integer> sumList = ConcurrencyMapUtil.parallelSum100(map, 100);

		assertNotEquals(1, sumList.stream().distinct().count());
		long wrongResultCount = sumList.stream().filter(num -> num != 100).count();

		assertTrue(wrongResultCount > 0);
	}

}
