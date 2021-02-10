package com.loggar.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReplaceAll {
	private static String m1(String s) {
		Pattern p = Pattern.compile("\\([^()]*\\)");
		Matcher m = p.matcher(s);

		while (m.find()) {
			s = m.replaceAll("");
			m = p.matcher(s);
		}

		return s.replaceAll("\\s{2,}", " ").trim();
	}

	private static String m2(String s) {
		return s.replaceAll("\\([^\\)]*\\)", "").replaceAll("\\s{2,}", " ").trim();
	}

	public static void main(String[] args) {
		String s = "CHANGHEE OTHER (Charly) (AND ELSE) LEE";

		System.out.println(m1(s));
		System.out.println(m2(s));
	}
}
