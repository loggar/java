package com.loggar.regex;

/**
 * How to replace 2 or more spaces with single space in string and delete leading spaces only
 * 
 * @author webnl
 *
 */
public class ReplaceTwoMoreSpaces {
	public static void main(String[] args) {
		String line = "  aa bbbbb   ccc     d  ";
		// " aa bbbbb ccc d "
		System.out.println(line.replaceAll("[\\s]+", " "));
	}
}
