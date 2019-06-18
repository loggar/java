package com.loggar.strings;

public class SystemLineSeparator {
	private static final String SYSTEM_LINE_SEPARATER = System.getProperty("line.separator");

	public static void main(String[] args) {
		System.out.println("Hearing in the distance");
		System.out.print(SYSTEM_LINE_SEPARATER + SYSTEM_LINE_SEPARATER);
		System.out.println("Two mandolins like creatures in the");
		System.out.print(SYSTEM_LINE_SEPARATER + SYSTEM_LINE_SEPARATER);
		System.out.println("dark");
		System.out.print(SYSTEM_LINE_SEPARATER + SYSTEM_LINE_SEPARATER);
		System.out.println("Creating the agony of ecstasy.");
		System.out.print(SYSTEM_LINE_SEPARATER + SYSTEM_LINE_SEPARATER);
		System.out.println("                - George Barker");
	}

}
