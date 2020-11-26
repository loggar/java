package com.loggar.io.standard_in;

import java.util.Scanner;

/**
 * Reading text by line from standard input
 * 
 * <pre>
 * java -cp ./target/classes com.loggar.standard.in.ReadLinesFromStdin < ./dist/io/in.txt
 * </pre>
 */
public class ReadLinesFromStdin {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine()) {
				String lineOfInput = scanner.nextLine();
				System.out.println(lineOfInput);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
