package com.loggar.io.standard_out;

/**
 * Writing to standard error
 *
 * Rewrite file
 * 
 * <pre>
 * java -cp ./target/classes com.loggar.standard.out.WriteStderr 2> ./dist/io/err.txt
 * </pre>
 * 
 * Append to file
 * 
 * <pre>
 * java -cp ./target/classes com.loggar.standard.out.WriteStderr 2>> ./dist/io/err.txt
 * </pre>
 */
public class WriteStderr {
	public static void main(String[] args) {
		System.err.print("Hello, "); // No newline at end
		System.err.println("World!"); // With newline at end

		// Formatted string.
		System.err.printf("Int: %d, String: %s, UpperHex: %X%n", 23, "Test", 42);
	}
}
