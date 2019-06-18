package com.loggar.strings;

import java.text.DecimalFormat;
import java.util.Formatter;

public class FormatDecimals {
	private static final String SYSTEM_LINE_SEPARATER = System.getProperty("line.separator");

	public static void main(String[] args) {
		double doubleValue = 3.1428733;
		float pi = 3.1428733f;

		System.out.println("doubleValue: "+ doubleValue);

		// String.format
		System.out.println("String.format: " + String.format("%.2f", pi)); // 2 decimal places

		// java.text.DecimalFormat
		DecimalFormat df = new DecimalFormat("#.##");
		String formatted = df.format(doubleValue);
		System.out.println("java.text.DecimalFormat: " + formatted);

		// java.util.Formatter
		Formatter formatter = new Formatter(new StringBuilder());
		formatter.format("%.4f", doubleValue); // 4 decimal places
		System.out.println("java.util.Formatter: " + formatter.toString());
		formatter.close();

		// Similarly you can format double to String in System.out.printf
		System.out.printf("System.out.printf: %.10f %n", doubleValue); // floating point number up-to 3 decimals

		System.out.printf("System.out.printf: %.2f" + SYSTEM_LINE_SEPARATER, pi);
	}
}
