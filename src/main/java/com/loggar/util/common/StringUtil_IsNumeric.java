package com.loggar.util.common;

public class StringUtil_IsNumeric {
	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}
}
