package com.loggar.pattern.builder;

public class ImmutableDog {
	private final String name;
	private final int weight;

	public ImmutableDog(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return this.name;
	}

	public int getWeight() {
		return this.weight;
	}
}
