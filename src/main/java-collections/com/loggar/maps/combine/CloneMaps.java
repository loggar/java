package com.loggar.maps.combine;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.loggar.maps.combine.MergeMaps.Employee;

public class CloneMaps {
	private static Map<String, Employee> map1 = new HashMap<>();

	static {
		Employee employee1 = new Employee(1L, "Henry");
		map1.put(employee1.getName(), employee1);
		Employee employee2 = new Employee(22L, "Annie");
		map1.put(employee2.getName(), employee2);
		Employee employee3 = new Employee(8L, "John");
		map1.put(employee3.getName(), employee3);
	}

	@Test
	public void map_clone() {
		Map<String, Employee> map2 = new HashMap<>();

		map1.forEach((key, value) -> map2.put(key, value.clone()));

		Assertions.assertTrue(map1.get("Henry") != map2.get("Henry"));
		Assertions.assertTrue(map1.get("Henry").equals(map2.get("Henry")));
	}
}
