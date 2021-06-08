package com.loggar.statements;

/**
 * jdk assertion enabling: VM arg "-ea" or "-enableassertions"
 *
 */
public class AssertSample2 {
	public static void main(String[] args) {
		long l = 8241; // java primative type
		int i = 8241;

		assert (l == i) : "l != i";

		Integer obj = Integer.valueOf(i);
		assert Long.valueOf(l).equals(obj) : "L not equals I";

		Object o1 = new Object();
		Object o2 = new Object();

		assert o1 == o2 : "o1 != o2";
	}
}
