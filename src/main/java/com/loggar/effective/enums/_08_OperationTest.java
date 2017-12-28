package com.loggar.effective.enums;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class _08_OperationTest {
	private <T extends Enum<T> & _08_Operation> void test(Class<T> opSet, double x, double y) {
		for (_08_Operation op : opSet.getEnumConstants())
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}

	@Test
	public void test1() {
		double x = 5;
		double y = 3;
		test(_08_ExtendedOperation.class, x, y);
	}

	private void test(Collection<? extends _08_Operation> opSet, double x, double y) {
		for (_08_Operation op : opSet)
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}

	@Test
	public void test2() {
		double x = 5;
		double y = 3;
		test(Arrays.asList(_08_ExtendedOperation.values()), x, y);
	}
}
