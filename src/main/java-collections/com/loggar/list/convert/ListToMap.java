package com.loggar.list.convert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

	public Map<Integer, Animal> convertListBeforeJava8(List<Animal> list) {
		Map<Integer, Animal> map = new HashMap<>();
		for (Animal animal : list) {
			map.put(animal.getId(), animal);
		}
		return map;
	}

	public Map<Integer, Animal> convertListAfterJava8(List<Animal> list) {
		Map<Integer, Animal> map = list.stream().collect(Collectors.toMap(Animal::getId, animal -> animal));
		return map;
	}
}

class Animal {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}