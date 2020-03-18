package com.loggar.maps.hashmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class HashMapIterates {
	Map<String, Product> productsByName = new HashMap<>();

	public HashMapIterates() {
		Product eBike = new Product("E-Bike", "A bike with a battery");
		Product roadBike = new Product("Road bike", "A bike for competition");
		productsByName.put(eBike.getName(), eBike);
		productsByName.put(roadBike.getName(), roadBike);
	}

	@Test
	public void testGet1() {
		Product nextPurchase = productsByName.get("E-Bike");
		assertEquals("A bike with a battery", nextPurchase.getDescription());
	}

	// If we try to find a value for a key that doesn't exist in the map, we'll get a null value:
	@Test
	public void testGet2() {
		Product nextPurchase = productsByName.get("Car");
		assertNull(nextPurchase);
	}

	// if we insert a second value with the same key, we'll only get the last inserted value for that key:
	@Test
	public void testGet3() {
		Product newEBike = new Product("E-Bike", "A bike with a better battery");
		productsByName.put(newEBike.getName(), newEBike);
		assertEquals("A bike with a better battery", productsByName.get("E-Bike").getDescription());
	}

	public void iterateMap1() {
		for (String key : productsByName.keySet()) {
			Product product = productsByName.get(key);
			System.out.println(product);
		}
	}

	public void iterateMap2() {
		for (Map.Entry<String, Product> entry : productsByName.entrySet()) {
			Product product = entry.getValue();
			String key = entry.getKey();
			System.out.printf("%s: %s%n", key, product);
		}
	}

	public void iterateForEach() {
		productsByName.forEach((key, product) -> {
			System.out.println("Key: " + key + " Product:" + product.getDescription());
			// do something with the key and value
		});
	}

}
