package com.loggar.numbers;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalConvert {
	@Test
	public void stringToBigDecimal() {
		String s = "0";
		
		BigDecimal bd = new BigDecimal(s);
		System.out.println(bd);
	}
}
