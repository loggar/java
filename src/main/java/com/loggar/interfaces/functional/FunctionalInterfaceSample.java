package com.loggar.interfaces.functional;

@FunctionalInterface
public interface FunctionalInterfaceSample {
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
