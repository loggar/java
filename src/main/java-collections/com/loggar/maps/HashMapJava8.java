package com.loggar.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

	@SuppressWarnings("unused")
	public void getOrDefault() {
		Product defaultProduct = productsByName.getOrDefault("horse carriage", chocolate);
		Product bike = productsByName.getOrDefault("E-Bike", chocolate);
	}

	@SuppressWarnings("unused")
	public void getOrDefault_priorToJava8() {
		Product bike2 = productsByName.containsKey("E-Bike") ? productsByName.get("E-Bike") : chocolate;
		Product defaultProduct2 = productsByName.containsKey("horse carriage") ? productsByName.get("horse carriage") : chocolate;
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
