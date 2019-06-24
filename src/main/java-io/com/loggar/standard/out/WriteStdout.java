package com.loggar.standard.out;

/**
 * Writing to standard output
 *
 */
public class WriteStdout {
	public static void main(String[] args) {
		System.out.print("Hello, "); // No newline at end
		System.out.println("World!"); // With newline at end

		// Formatted string.
		System.out.printf("Int: %d, String: %s, UpperHex: %X", 23, "Test", 42);
	}
}
