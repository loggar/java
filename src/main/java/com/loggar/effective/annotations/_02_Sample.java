package com.loggar.effective.annotations;

//Program containing annotations with a parameter
public class _02_Sample {
	@_02_ExceptionTest(ArithmeticException.class)
	public static void m1() { // Test should pass
		int i = 0;
		i = i / i;
	}

	@_02_ExceptionTest(ArithmeticException.class)
	public static void m2() { // Should fail (wrong exception)
		int[] a = new int[0];
		int i = a[1];
		System.out.println(i);
	}

	@_02_ExceptionTest(ArithmeticException.class)
	public static void m3() {
	} // Should fail (no exception)
}
