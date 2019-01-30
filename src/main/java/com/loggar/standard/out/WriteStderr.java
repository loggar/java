package com.loggar.standard.out;

/**
 * Writing to standard error
 *
 */
public class WriteStderr {
	public static void main(String[] args) {
		System.err.print("Hello, "); // No newline at end
		System.err.println("World!"); // With newline at end

		// Formatted string.
		System.err.printf("Int: %d, String: %s, UpperHex: %X", 23, "Test", 42);
	}
}
