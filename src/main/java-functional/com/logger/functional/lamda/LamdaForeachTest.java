package com.logger.functional.lamda;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LamdaForeachTest {
	@Test
	public void test() {
		List<Integer> v = Arrays.asList(4, 5, 6, 7, 8, 9);

		/*
		 * internal loops : the loop logic has alrealdy been contained in the List class. instance of Consumer<T>
		 */
		v.forEach(i -> System.out.println(i)); // and lamda expression.
	}

}
