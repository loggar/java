package com.loggar.effective.enums;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

public class _34_OperationTest {
	private <T extends Enum<T> & _34_Operation> void test(Class<T> opSet, double x, double y) {
		for (_34_Operation op : opSet.getEnumConstants())
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}

	@Test
	public void test1() {
		double x = 5;
		double y = 3;
		test(_34_ExtendedOperation.class, x, y);
	}

	private void test(Collection<? extends _34_Operation> opSet, double x, double y) {
		for (_34_Operation op : opSet)
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}

	@Test
	public void test2() {
		double x = 5;
		double y = 3;
		test(Arrays.asList(_34_ExtendedOperation.values()), x, y);
	}
}
