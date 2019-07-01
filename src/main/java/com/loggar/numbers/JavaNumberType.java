package com.loggar.numbers;

import org.junit.jupiter.api.Test;

public class JavaNumberType {
	@Test
	public void testNumberObjects() {
		int i = 5000;
		float gpa = (float) 13.65;
		double mask = 0xaf;

		int r = i + ((Number) gpa).intValue() + ((Number) mask).intValue();
		System.out.println(r);
	}
	
	@Test
	public void numberType() {
		Number n1 = 1.01;
		Number n2 = 0.01;
		
		System.out.println(n1);
		System.out.println(n2.doubleValue() <= 0);
	}
}
