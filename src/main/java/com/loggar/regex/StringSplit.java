package com.loggar.regex;

import java.util.ArrayList;
import java.util.List;

public class StringSplit {
	public static void main(String[] args) {
		String line = "aaa,bbb,\"c,c\",dd;dd,\"e,e";
		List<String> toks = splitComma(line);
		for (String t : toks) {
			System.out.println("> " + t);
		}
	}

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

	/**
	 * How to split a comma-separated string but ignoring commas in quotes?
	 * 
	 * @param str
	 * @return
	 */
	private static List<String> splitComma(String str) {
		int start = 0;
		List<String> toks = new ArrayList<String>();
		boolean withinQuote = false;
		for (int end = 0; end < str.length(); end++) {
			char c = str.charAt(end);
			switch (c) {
			case ',':
				if (!withinQuote) {
					toks.add(str.substring(start, end));
					start = end + 1;
				}
				break;
			case '\"':
				withinQuote = !withinQuote;
				break;
			}
		}
		if (start < str.length()) {
			toks.add(str.substring(start));
		}
		return toks;
	}
}
