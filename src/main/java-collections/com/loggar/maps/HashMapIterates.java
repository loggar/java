package com.loggar.maps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

	public class Product {

		private String name;
		private String description;
		private List<String> tags;

		public Product(String name, String description) {
			super();
			this.name = name;
			this.description = description;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}

			Product product = (Product) o;
			return Objects.equals(name, product.name) && Objects.equals(description, product.description);
		}

		// We can use any class as the key in our HashMap. However, for the map to work properly, we need to provide an implementation for equals() and hashCode().
		@Override
		public int hashCode() {
			return Objects.hash(name, description);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<String> getTags() {
			return tags;
		}

		public void setTags(List<String> tags) {
			this.tags = tags;
		}

		public Product addTagsOfOtherProdcut(Product product) {
			this.tags.addAll(product.getTags());
			return this;
		}

	}
}
