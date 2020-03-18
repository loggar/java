package com.loggar.maps.hashmap;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class HashMapJava8 {
	Map<String, Product> productsByName = new HashMap<>();

	Product chocolate = new Product("chocolate", "something sweet");
	Product eBike2 = new Product("E-Bike", "A bike with a battery");

	public HashMapJava8() {
		Product eBike = new Product("E-Bike", "A bike with a battery");
		Product roadBike = new Product("Road bike", "A bike for competition");
		productsByName.put(eBike.getName(), eBike);
		productsByName.put(roadBike.getName(), roadBike);
	}

	@Test
	public void forEach() {
		productsByName.forEach((key, product) -> {
			System.out.println("Key: " + key + " Product:" + product.getDescription());
			// do something with the key and value
		});
	}

	@Test
	public void getOrDefault() {
		Product bike = productsByName.getOrDefault("E-Bike", chocolate);
		Product defaultProduct = productsByName.getOrDefault("horse carriage", chocolate);

		System.out.println(bike);
		System.out.println(defaultProduct);
	}

	@Test
	public void getOrDefault_priorToJava8() {
		Product bike2 = productsByName.containsKey("E-Bike") ? productsByName.get("E-Bike") : chocolate;
		Product defaultProduct2 = productsByName.containsKey("horse carriage") ? productsByName.get("horse carriage") : chocolate;

		System.out.println(bike2);
		System.out.println(defaultProduct2);
	}

	// With this method, we can add a new mapping, but only if there is not yet a mapping for the given key:
	public void putIfAbsent() {
		productsByName.putIfAbsent("E-Bike", chocolate);
	}

	public void putIfAbsent_priorToJava8() {
		if (productsByName.containsKey("E-Bike")) {
			productsByName.put("E-Bike", chocolate);
		}
	}

	// And with merge(), we can modify the value for a given key if a mapping exists, or add a new value otherwise:
	public void merge() {
		eBike2.getTags().add("sport");
		productsByName.merge("E-Bike", eBike2, Product::addTagsOfOtherProdcut);
	}

	public void merge_priorToJava8() {
		if (productsByName.containsKey("E-Bike")) {
			productsByName.get("E-Bike").addTagsOfOtherProdcut(eBike2);
		} else {
			productsByName.put("E-Bike", eBike2);
		}
	}

	// And with merge(), we can modify the value for a given key if a mapping exists, or add a new value otherwise:
	public void compute() {
		productsByName.compute("E-Bike", (k, v) -> {
			if (v != null) {
				return v.addTagsOfOtherProdcut(eBike2);
			} else {
				return eBike2;
			}
		});
	}

	public void compute_priorToJava8() {
		if (productsByName.containsKey("E-Bike")) {
			productsByName.get("E-Bike").addTagsOfOtherProdcut(eBike2);
		} else {
			productsByName.put("E-Bike", eBike2);
		}
	}
}
