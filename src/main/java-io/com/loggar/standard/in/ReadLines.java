package com.loggar.standard.in;

import java.util.Scanner;

/**
 * Reading standard input line-by-line
 *
 */
public class ReadLines {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// Read and print out each line.
			while (scanner.hasNextLine()) {
				String lineOfInput = scanner.nextLine();
				System.out.println(lineOfInput);
			}
		} catch (Exception ex) {
			// exception handling...do something (e.g., print the error message)
			ex.printStackTrace();
		}
	}
}
