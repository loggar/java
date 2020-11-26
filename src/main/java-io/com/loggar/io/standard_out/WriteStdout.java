package com.loggar.io.standard_out;

/**
 * Writing to standard output
 * 
 * Rewrite file
 * 
 * <pre>
 * java -cp ./target/classes com.loggar.standard.out.WriteStdout > ./dist/io/out.txt
 * </pre>
 * 
 * Append to file
 * 
 * <pre>
* java -cp ./target/classes com.loggar.standard.out.WriteStdout >> ./dist/io/out.txt
 * </pre>
 */
public class WriteStdout {
	public static void main(String[] args) {
		System.out.print("Hello, "); // No newline at end
		System.out.println("World!"); // With newline at end

		// Formatted string.
		System.out.printf("Int: %d, String: %s, UpperHex: %X%n", 23, "Test", 42);
	}
}
