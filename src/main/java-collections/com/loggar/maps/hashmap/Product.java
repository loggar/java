package com.loggar.maps.hashmap;

import java.util.List;
import java.util.Objects;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product (").append(hashCode()).append(") [name=").append(name).append(", description=").append(description).append(", tags=").append(tags).append("]");
		return builder.toString();
	}

}
