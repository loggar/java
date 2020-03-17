package com.loggar.maps.concurrency;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class ConcurrentHashMapPerformance {
	@Test
	public void givenMaps_whenGetPut500KTimes_thenConcurrentMapFaster() throws Exception {
		Map<String, Object> hashtable = new Hashtable<>();
		Map<String, Object> synchronizedHashMap = Collections.synchronizedMap(new HashMap<>());
		Map<String, Object> concurrentHashMap = new ConcurrentHashMap<>();

		long hashtableAvgRuntime = timeElapseForGetPut("Hashtable", hashtable);
		long syncHashMapAvgRuntime = timeElapseForGetPut("Collections.synchronizedMap", synchronizedHashMap);
		long concurrentHashMapAvgRuntime = timeElapseForGetPut("ConcurrentHashMap", concurrentHashMap);

		assertTrue(hashtableAvgRuntime > concurrentHashMapAvgRuntime);
		assertTrue(syncHashMapAvgRuntime > concurrentHashMapAvgRuntime);
	}

	private long timeElapseForGetPut(String mapType, Map<String, Object> map) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		long startTime = System.nanoTime();
		for (int i = 0; i < 4; i++) {
			executorService.execute(() -> {
				for (int j = 0; j < 500_000; j++) {
					int value = ThreadLocalRandom.current().nextInt(10000);
					String key = String.valueOf(value);
					map.put(key, value);
					map.get(key);
				}
			});
		}
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
		long timeElapsed = (System.nanoTime() - startTime);
		System.out.printf("Time elapsed(nano-seconds) for %s: %d%n", mapType, timeElapsed);
		return timeElapsed;
	}
}
