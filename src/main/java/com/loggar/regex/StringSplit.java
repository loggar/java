package com.loggar.regex;

public class StringSplit {
	public static String[] splitByNewLine1(String str) {
		String lines[] = str.split("\\r?\\n");

		return lines;
	}

	public static String[] splitByNewLine2(String str) {
		String lines[] = str.split(System.getProperty("line.separator"));

		return lines;
	}

	public static String[] splitByNewLineAndIgnoreEmptyLine(String str) {
		String lines[] = str.split("[\\r\\n]+");

		return lines;
	}
}
