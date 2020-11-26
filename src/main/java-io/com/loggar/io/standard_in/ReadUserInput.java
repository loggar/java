package com.loggar.io.standard_in;

import java.util.Scanner;

/**
 * Prompting user for input
 *
 */
public class ReadUserInput {
	public static void main(String[] args) {
		// Create a scanner to wrap the standard input stream

		try (Scanner scanner = new Scanner(System.in)) {
			// Prompt user to enter a string and press enter
			System.out.print("Enter your name: ");
			System.out.println("Hello, " + scanner.nextLine());

			// Use the scanner to then get a numeric value from the user.
			System.out.print("Enter an integer: ");
			System.out.println("Your number plus 1 is: " + (scanner.nextInt() + 1));
		} catch (Exception ex) {
			// exception handling...do something (e.g., print the error message)
			ex.printStackTrace();
		}

	}
}
