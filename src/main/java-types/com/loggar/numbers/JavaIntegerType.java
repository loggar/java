package com.loggar.numbers;

import org.junit.Test;

public class JavaIntegerType {
	@Test
	public void integerCalculates() {
		int a = 574;
		int b = 1211;

		int r = (a / b) * 100;

		System.out.println(r); // 0
	}

	@Test
	public void integerCalculates2() {
		int a = 574;
		int b = 1211;

		double r = ((double) a / (double) b) * 100;

		System.out.println(r); // 47.398843930635834
	}
}
