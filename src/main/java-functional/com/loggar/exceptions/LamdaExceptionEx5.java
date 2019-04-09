package com.loggar.exceptions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
 * Handling Checked Exceptions
 * 
 * Throwing Checked Exception from Lambda Expressions
 */

public class LamdaExceptionEx5 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(throwingConsumerWrapper(i -> writeToFile(i)));
	}

	static void writeToFile(Integer integer) throws IOException {
		// logic to write to file which throws IOException
	}

	@FunctionalInterface
	public interface ThrowingConsumer<T, E extends Exception> {
		void accept(T t) throws E;
	}

	public static <T> Consumer<T> throwingConsumerWrapper(ThrowingConsumer<T, Exception> throwingConsumer) {
		return i -> {
			try {
				throwingConsumer.accept(i);
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		};
	}
}
