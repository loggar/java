package com.loggar.pattern.builder;

public class ImmutableDogBuilder {
	private String name;
	private int weight;

	public ImmutableDogBuilder() {
	}

	public ImmutableDog build() {
		return new ImmutableDog(name, weight);
	}

	public ImmutableDogBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public ImmutableDogBuilder setWeight(int weight) {
		this.weight = weight;
		return this;
	}

	public String getName() {
		return this.name;
	}

	public int getWeight() {
		return this.weight;
	}
}

/*
 * Note the setters I really like this pattern of returning this on each setters in builder classes, because it creates a very fluent api. You could use this ImmutableDogBuilder like this:
 * 
 * ImmutableDogBuilder dogBuilder = new ImmutableDogBuilder().setName("Rover").setWeight(25);
 */