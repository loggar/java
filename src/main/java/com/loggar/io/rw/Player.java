package com.loggar.io.rw;

import java.io.Serializable;

public class Player implements Serializable {
	/**
	 * generated serial version UID.
	 */
	private static final long serialVersionUID = -1040643232391324942L;

	String name = null;
	int age = -1;

	public Player(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [name=").append(name).append(", age=").append(age).append("]");
		return builder.toString();
	}
}
