package com.loggar.maps.combine;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeMaps {
	private static Map<String, Employee> map1 = new HashMap<>();
	private static Map<String, Employee> map2 = new HashMap<>();

	static {
		Employee employee1 = new Employee(1L, "Henry");
		map1.put(employee1.getName(), employee1);
		Employee employee2 = new Employee(22L, "Annie");
		map1.put(employee2.getName(), employee2);
		Employee employee3 = new Employee(8L, "John");
		map1.put(employee3.getName(), employee3);

		Employee employee4 = new Employee(2L, "George");
		map2.put(employee4.getName(), employee4);
		Employee employee5 = new Employee(3L, "Henry");
		map2.put(employee5.getName(), employee5);
	}

	@Test
	public void map_merge() {
		Map<String, Employee> result = new HashMap<>(map1);

		map2.forEach((key, value) -> result.merge(key, value, (v1, v2) -> new Employee(v1.getId(), v2.getName())));

		Assertions.assertTrue(result.size() == 4);
	}

	@Test
	public void stream_concat() {
		// The Stream API in Java 8 can also provide an easy solution to our problem. First, we need to combine our Map instances into one Stream. That's exactly what Stream.concat() operation does:
		// Stream combined = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream());

		// Here we pass the map entry sets as parameters. Next, we need to collect our result into a new Map. For that we can use Collectors.toMap():
		// Map<String, Employee> result = combined.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		// As a result, the collector will use the existing keys and values of our maps. But this solution is far from being perfect. As soon as our collector meets entries with duplicate keys, it'll throw an IllegalStateException.
		// (value1, value2) -> new Employee(value2.getId(), value1.getName())

		Map<String, Employee> result = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> new Employee(value2.getId(), value1.getName())));

		Assertions.assertTrue(result.size() == 4);
	}

	@Test
	public void stream_of() {
		// To continue to use the Stream API, we can turn our Map instances into a unified stream with the help of Stream.of().
		// Here we don't have to create an additional collection to work with the streams:
		Map<String, Employee> result = Stream.of(map1, map2).flatMap(map -> map.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> new Employee(v1.getId(), v2.getName())));

		Assertions.assertTrue(result.size() == 4);
	}

	@Test
	public void simple_streaming() {
		// Additionally, we can use a stream() pipeline to assemble our map entries. The code snippet below demonstrates how to add the entries from map2 and map1 by ignoring the duplicate entries:
		Map<String, Employee> result = map2.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> new Employee(v1.getId(), v2.getName()), () -> new HashMap<>(map1)));

		Assertions.assertTrue(result.size() == 4);
	}

	// @Test
	public void stream_ex() {
		// we can also use the popular StreamEx library.
		// Map<String, Employee> map3 = EntryStream.of(map1).append(EntryStream.of(map2)).toMap((e1, e2) -> e1);
		/*
		 * <dependency> <groupId>one.util</groupId> <artifactId>streamex</artifactId> </dependency>
		 */
	}

	static class Employee {
		private Long id;
		private String name;

		public Employee(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public Employee clone() {
			Employee n = new Employee(this.id, this.name);
			return n;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Employee [id=").append(id).append(", name=").append(name).append("]");
			return builder.toString();
		}
	}
}
