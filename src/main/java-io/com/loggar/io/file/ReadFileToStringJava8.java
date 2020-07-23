package com.loggar.io.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileToStringJava8 {
	public static void main(String[] args) {
		String filePath = "./dist/io/append.txt";

		System.out.println(readLineByLineJava8(filePath));
	}

	// Read file content into string with - Files.lines(Path path, Charset cs)

	private static String readLineByLineJava8(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append(System.lineSeparator()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}
}
