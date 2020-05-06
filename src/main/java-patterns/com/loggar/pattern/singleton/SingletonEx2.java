package com.loggar.pattern.singleton;

public enum SingletonEx2 {
	INSTANCE;

	/**
	 * If you prefer to follow the class diagram conventions:
	 */
	public static synchronized SingletonEx2 getInstance() {
		return INSTANCE;
	}

	public String capitalizer(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
