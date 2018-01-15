package com.loggar.io.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamReadFile {
	public static void main(String args[]) {
		String file = "./dist/io/append.txt";

		// lines() and Stream Approach
		ReadFile1(file);

		// newBufferedReader and Stream Approach
		ReadFile2(file);
	}

	// Read file using lines() and Stream Approach
	private static void ReadFile1(String file) {

		Stream<String> stream = null;
		try {

			// Read all lines from a file as a Stream. Bytes from the file are decoded into
			// characters using the UTF-8 charset
			stream = Files.lines(Paths.get(file));

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("============= Result from lines() and Stream Approach =============");
		stream.forEach(System.out::println);
	}

	// Read file using newBufferedReader and Stream Approach
	private static void ReadFile2(String file) {
		List<String> list = new ArrayList<>();

		BufferedReader bufferReader = null;
		try {

			// newBufferedReader opens a file for reading
			bufferReader = Files.newBufferedReader(Paths.get(file));

		} catch (IOException e) {
			e.printStackTrace();
		}

		// toList: returns a Collector that accumulates the input elements into a new
		// List
		// lines(): returns a Stream, the elements of which are lines read from this
		// BufferedReader
		list = bufferReader.lines().collect(Collectors.toList());

		System.out.println("\n============= Result from newBufferedReader and Stream Approach =============");

		// forEach: performs the given action for each element of the Iterable until all
		// elements have been processed or the
		// action throws an exception.
		list.forEach(System.out::println);
	}
}
