package com.loggar.effective.general_programming;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimal_for_exact_numbers {
	@Test
	public void test1() {
		System.out.println(1.03 - .42);

		BigDecimal bd_1 = new BigDecimal(1.03);
		BigDecimal bd_2 = new BigDecimal(.42);
		BigDecimal r_1 = bd_1.subtract(bd_2);
		System.out.println(r_1);

		System.out.println(1.00 - 9 * .10);

		BigDecimal bd_3 = new BigDecimal(1.00);
		BigDecimal bd_4 = new BigDecimal(9);
		BigDecimal bd_5 = new BigDecimal(.10);
		BigDecimal r_2 = bd_3.subtract(bd_4.multiply(bd_5));
		System.out.println(r_2);
	}
}
