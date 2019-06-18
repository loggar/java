package com.loggar.io.console;

public class ConsoleInputSystemConsole {
	public static void main(String[] args) {
		// Using Console to input data from user
		// Usable only inside console
		String name = System.console().readLine();
		System.out.println(name);
	}
}
