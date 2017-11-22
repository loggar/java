package com.loggar.practice.string;

public class CharArrayToString {
	public static void main(String[] args) {
		char[] myString = new char[] { 'T', 'H', 'I', 'S', ' ', 'I', 'S', ' ', 'T', 'E', 'S', 'T' };

		String output1 = new String(myString);
		System.out.println("output1 : " + output1);

		String output2 = String.valueOf(myString);
		System.out.println("output2 : " + output2);
	}
}
