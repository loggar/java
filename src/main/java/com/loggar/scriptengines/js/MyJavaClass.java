package com.loggar.scriptengines.js;

public class MyJavaClass {
	public static String sayHello(String name) {
		return String.format("Hello %s from Java!", name);
	}

	public int add(int a, int b) {
		return a + b;
	}

	public static void printType(Object object) {
		System.out.println(object.getClass());
	}
}
