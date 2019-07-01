package com.loggar.statements;

import org.junit.jupiter.api.Test;

/**
 * Assertions are Boolean expressions used to check whether code
 * behaves as expected while running in debug mode (i.e., using
 * the -enableassertions or -ea switch with the Java interpreter).
 */
public class AssertSample {
	@Test
	public void assertSampleTest() {
		int i = 4;
		
		assert (i<5) : "Invalid value : " + i;
		
		System.out.println("not reached if assertion above failed.");
	}
}
