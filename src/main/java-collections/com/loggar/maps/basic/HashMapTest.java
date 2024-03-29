package com.loggar.maps.basic;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashMapTest {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Test
	public void map_java8() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("a", "value_1");
		map.put("b", "some_value");
		map.replace("a", "value_2");
		
		logger.debug(map.toString());
	}
	
	@Test
	public void map_java7() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", "value_1");
		map.put("b", "some_value");
		map.remove("a");
		map.put("a", "value_2");
		
		logger.debug(map.toString());
	}
	
	@Test
	public void map_java7_2() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", "value_1");
		map.put("b", "some_value");
		map.put("a", "value_2");
		
		logger.debug(map.toString());
	}
}
