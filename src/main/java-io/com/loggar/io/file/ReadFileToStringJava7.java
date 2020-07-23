package com.loggar.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFileToStringJava7 {
	public static void main(String[] args) {
		String filePath = "c:/temp/data.txt";

		System.out.println(readAllBytesJava7(filePath));
	}

	// Read file content into string with - Files.readAllBytes(Path path)

	private static String readAllBytesJava7(String filePath) {
		String content = "";

		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
	}
}
