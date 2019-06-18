package com.loggar.io.console;

public class ConsoleInputSystemConsole {
	public static void main(String[] args) {
		// Using Console to input data from user
		// Usable only inside console
		// ~\target $ java -cp ./classes com.loggar.io.console.ConsoleInputSystemConsole
		String name = System.console().readLine();
		System.out.println(name);
	}
}
