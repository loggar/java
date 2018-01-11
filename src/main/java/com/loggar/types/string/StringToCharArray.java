package com.loggar.types.string;

public class StringToCharArray {
	public static void main(String[] args) {
		String testString = "This Is Test";
		char[] stringToCharArray = testString.toCharArray();

		for (char output : stringToCharArray) {
			System.out.println(output);
		}
	}
}
