package com.loggar.exceptions;

import java.util.Arrays;
import java.util.List;

/*
 * Handling Unchecked Exceptions
 */
public class LamdaExceptionEx1 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(i -> {
			try {
				System.out.println(50 / i);
			} catch (ArithmeticException e) {
				System.err.println("Arithmetic Exception occured : " + e.getMessage());
			}
		});
	}
}
