package com.loggar.strings;

public class SystemLineSeparator {
	private static final String SYSTEM_LINE_SEPARATER = System.getProperty("line.separator");
	private static final String SYSTEM_NEW_LINE = System.lineSeparator(); // java 1.7 or later

	public static void main(String[] args) {
		System.out.println("Hearing in the distance");
		System.out.print(SYSTEM_LINE_SEPARATER + SYSTEM_LINE_SEPARATER);
		System.out.println("Two mandolins like creatures in the");
		System.out.print(SYSTEM_LINE_SEPARATER + SYSTEM_LINE_SEPARATER);
		System.out.println("dark");
		System.out.print(SYSTEM_LINE_SEPARATER + SYSTEM_LINE_SEPARATER);
		System.out.println("Creating the agony of ecstasy.");
		System.out.print(SYSTEM_NEW_LINE + SYSTEM_NEW_LINE);
		System.out.println("                - George Barker");
	}

}
