package com.loggar.functional.exceptions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/*
 * Handling Checked Exceptions
 * 
 * Throwing Checked Exception from Lambda Expressions
 */
public class LamdaExceptionEx4 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(i -> {
			try {
				writeToFile(i);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});
	}

	static void writeToFile(Integer integer) throws IOException {
		// logic to write to file which throws IOException
	}
}
