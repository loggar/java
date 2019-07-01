package com.loggar.test.junit4.examples;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

public class ClassToBeTested {
	@Test
	public void test1(int v) {
		assertTrue(1 > v);
		assertFalse(1 == v);
	}
}
