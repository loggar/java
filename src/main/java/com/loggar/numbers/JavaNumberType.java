package com.loggar.numbers;

import org.junit.Test;

public class JavaNumberType {
	@Test
	public void testNumberObjects() {
		int i = 5000;
		float gpa = (float) 13.65;
		double mask = 0xaf;

		int r = i + ((Number) gpa).intValue() + ((Number) mask).intValue();
		System.out.println(r);
	}
}
