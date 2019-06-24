package com.loggar.standard.out;

/**
 * Writing to standard output
 * 
 * Rewrite file
 * 
 * <pre>
 * java -cp ./target/classes com.loggar.standard.out.WriteStdOutErr > ./dist/io/out.txt 2> ./dist/io/err.txt
 * </pre>
 * 
 * Append to file
 * 
 * <pre>
* java -cp ./target/classes com.loggar.standard.out.WriteStdOutErr >> ./dist/io/out.txt 2>> ./dist/io/err.txt
 * </pre>
 * 
 * Rewirte in onefile both out, err
 * 
 * <pre>
* java -cp ./target/classes com.loggar.standard.out.WriteStdOutErr > ./dist/io/out_err.txt 2>&1
 * </pre>
 */
public class WriteStdOutErr {
	public static void main(String[] args) {
		System.out.print("Hello, "); // No newline at end
		System.out.println("World!"); // With newline at end

		// Formatted string.
		System.out.printf("Int: %d, String: %s, UpperHex: %X%n", 23, "Test", 42);

		System.err.print("Hello, "); // No newline at end
		System.err.println("World!"); // With newline at end

		// Formatted string.
		System.err.printf("Int: %d, String: %s, UpperHex: %X%n", 23, "Test", 42);
	}
}
