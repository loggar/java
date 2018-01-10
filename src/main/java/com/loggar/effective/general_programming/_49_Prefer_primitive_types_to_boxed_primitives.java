package com.loggar.effective.general_programming;

import java.util.Comparator;

import org.junit.Test;

public class _49_Prefer_primitive_types_to_boxed_primitives {
	@Test
	public void test1() {
		Comparator<Integer> naturalOrder = new Comparator<Integer>() {
			public int compare(Integer first, Integer second) {
				return first < second ? -1 : (first == second ? 0 : 1);
			}
		};

		System.out.println(naturalOrder.compare(new Integer(42), new Integer(42))); // it is not 0 !
	}

	@Test
	public void test2() {
		Comparator<Integer> naturalOrder = new Comparator<Integer>() {
			public int compare(Integer first, Integer second) {
				int f = first; // Auto-unboxing
				int s = second; // Auto-unboxing
				return f < s ? -1 : (f == s ? 0 : 1); // No unboxing
			}
		};

		System.out.println(naturalOrder.compare(new Integer(42), new Integer(42))); // it is good.
	}

	@Test
	public void test3() {
		Long sum = 0L; // Hideously slow program!
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);

		/*
		 * This program is much slower than it should be because it accidentally
		 * declares a local variable (sum) to be of the boxed primitive type Long
		 * instead of the primitive type long. The program compiles without error or
		 * warning, and the variable is repeatedly boxed and unboxed, causing the
		 * observed performance degradation.
		 */
	}
}
