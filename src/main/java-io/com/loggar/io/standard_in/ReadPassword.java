package com.loggar.io.standard_in;

import java.io.Console;

/**
 * Prompting user for a password
 *
 */
public class ReadPassword {
	public static void main(String[] args) {
		Console console = System.console();
		char[] passwd = console.readPassword("Enter the secret password: ");

		System.out.println(passwd);
		
	}
}
