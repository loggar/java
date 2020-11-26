package com.loggar.io.standard_out;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SystemSetOut {
	public static void main(String[] args) {
		PrintStream originalOut = System.out;
		PrintStream originalErr = System.err;

		try (PrintStream fileOut = new PrintStream("./dist/io/out.txt"); PrintStream fileErr = new PrintStream("./dist/io/err.txt");) {
			System.setOut(fileOut);
			System.setErr(fileErr);

			System.out.println("out 1");
			System.err.println("err 1");

			System.setOut(originalOut);
			System.setErr(originalErr);

			System.out.println("out 2");
			System.err.println("err 2");

		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
	}
}
