package com.loggar.test.junit4.examples;

import org.junit.Assume;
import org.junit.jupiter.api.Test;

public class AssumeFalseTrue {
	// The @Ignore annotation allow to statically ignore a test.
	// Alternatively you can use Assume.assumeFalse or Assume.assumeTrue to define a condition for the test.
	// Assume.assumeFalse marks the test as invalid, if its condition evaluates to true.
	// Assume.assumeTrue evaluates the test as invalid if its condition evaluates to false.
	// For example, the following disables a test on Linux:
	
	@Test
	public void test1() {
		System.out.println(System.getProperty("os.name"));

		// they are identical
		Assume.assumeFalse(System.getProperty("os.name").contains("Linux"));
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows 10"));
	}
}
