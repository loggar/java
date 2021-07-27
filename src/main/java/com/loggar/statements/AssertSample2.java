package com.loggar.statements;

/**
 * jdk assertion enabling: VM arg "-ea" or "-enableassertions"
 *
 */
public class AssertSample2 {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		long l = 8241; // java primitive type
		int i = 8241;

		assert (l == i) : "l != i";

		assert Long.valueOf(l).equals(Integer.valueOf(1)) : "L not equals I";

		Object o1 = new Object();
		Object o2 = new Object();

		assert o1 == o2 : "new Object() != new Object()";
	}
}
