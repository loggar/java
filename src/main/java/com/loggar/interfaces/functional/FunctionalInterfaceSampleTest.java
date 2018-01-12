package com.loggar.interfaces.functional;

import org.junit.Test;

public class FunctionalInterfaceSampleTest {
	@Test
	public void test() {
		FunctionalInterfaceSample fn = () -> System.out.println("Functional Interface !");
		
		fn.doAbstractTask();
		fn.performTask1();
		fn.performTask2();
	}
}
