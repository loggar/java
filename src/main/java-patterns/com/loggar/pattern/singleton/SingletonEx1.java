package com.loggar.pattern.singleton;

public class SingletonEx1 {
	private static final SingletonEx1 INSTANCE = new SingletonEx1();

	/**
	 * This cannot be instantiated from the others.
	 */
	private SingletonEx1() {
	}

	public static synchronized  SingletonEx1 getInstance() {
		return INSTANCE;
	}

	public String capitalizer(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
