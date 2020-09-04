package com.loggar.arrays;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VarargsHeapPollution {
	// Using varargs can lead to so-called Heap Pollution. To better understand the heap pollution, consider this varargs method:
	@SafeVarargs
	static String firstOfFirst(List<String>... strings) {
		List<Integer> ints = Collections.singletonList(42);
		Object[] objects = strings;
		objects[0] = ints; // Heap pollution

		return strings[0].get(0); // ClassCastException
	}

	// If we call this strange method in a test:
	// java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String
	public void test1() {
		String one = firstOfFirst(Arrays.asList("one", "two"), Collections.emptyList());

		assertEquals("one", one);
	}

	// Safe Usage
	// Every time we use varargs, the Java compiler creates an array to hold the given parameters. In this case, the compiler creates an array with generic type components to hold the arguments.
	// When we use varargs with generic types, as there's a potential risk of a fatal runtime exception, the Java compiler warns us about a possible unsafe varargs usage:
	// warning: [varargs] Possible heap pollution from parameterized vararg type T

	// The varargs usage is safe if and only if:
	// 1. We don't store anything in the implicitly created array. In this example, we did store a List<Integer> in that array
	// 2. We don't let a reference to the generated array escape the method (more on this later)
	// If we are sure that the method itself does safely use the varargs, we can use @SafeVarargs to suppress the warning.

}
