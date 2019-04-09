package com.loggar.exceptions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
 * Handling Checked Exceptions
 * 
 * Handling a Checked Exception in Lambda Expression
 */

public class LamdaExceptionEx6 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(handlingConsumerWrapper(i -> writeToFile(i), IOException.class));
	}

	static void writeToFile(Integer integer) throws IOException {
		// logic to write to file which throws IOException
	}

	@FunctionalInterface
	public interface ThrowingConsumer<T, E extends Exception> {
		void accept(T t) throws E;
	}

	public static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {

		return i -> {
			try {
				throwingConsumer.accept(i);
			} catch (Exception ex) {
				try {
					E exCast = exceptionClass.cast(ex);
					System.err.println("Exception occured : " + exCast.getMessage());
				} catch (ClassCastException ccEx) {
					throw new RuntimeException(ex);
				}
			}
		};
	}
}
