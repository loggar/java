package com.loggar.interfaces.functional_interfaces;

import org.junit.Test;

public class FunctionalInterfaceSampleTest {
	@FunctionalInterface
	private interface FunctionalInterfaceSample {
		// Only one abstract method allowed
		public void doAbstractTask();

		// Multiple default methods allowed
		default public void performTask1() {
			System.out.println("Msg from task 1.");
		}

		default public void performTask2() {
			System.out.println("Msg from task 2.");
		}
	}

	@Test
	public void test() {
		FunctionalInterfaceSample fn = () -> System.out.println("Functional Interface !");

		fn.doAbstractTask();
		fn.performTask1();
		fn.performTask2();
	}
}
