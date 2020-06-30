package com.loggar.structure.circular;

public class NodeValue {
	String name;
	int v;

	public NodeValue(String name, int v) {
		this.name = name;
		this.v = v;
	}

	public String getName() {
		return name;
	}

	public int getV() {
		return v;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NodeValue [name=").append(name).append(", v=").append(v).append("]");
		return builder.toString();
	}

}
