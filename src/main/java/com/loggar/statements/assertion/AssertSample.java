package com.loggar.statements.assertion;

import org.junit.Test;

/**
 * Assertions are Boolean expressions used to check whether code
 * behaves as expected while running in debug mode (i.e., using
 * the -enableassertions or -ea switch with the Java interpreter).
 */
public class AssertSample {
	@Test
	public void assertSampleTest() {
		int i = 7;
		
		assert (i>4 && i< 9) : "Invalid value : " + i;
		
		assert (i<5) : "Invalid value : " + i;
		
		System.out.println("not reached.");
	}
}
