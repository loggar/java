package com.loggar.structure.circular;

public class CounterObject {
	private String name;
	private int v;

	public CounterObject(String name, int v) {
		this.name = name;
		this.v = v;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [name=").append(name).append(", v=").append(v).append("]");
		return builder.toString();
	}

	public String getName() {
		return name;
	}

	public int getV() {
		return v;
	}

}
