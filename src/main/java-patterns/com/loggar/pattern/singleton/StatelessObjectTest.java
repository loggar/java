package com.loggar.pattern.singleton;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StatelessObjectTest {
	/**
	 * Stateless Object: No matter how many instances exist, the results of action are identical.
	 */
	@Test
	public void test() {
		StatelessObject i1 = new StatelessObject();
		StatelessObject i2 = new StatelessObject();

		assertTrue(i1 != i2);
		assertTrue(i1.capitalizer("student1").equals(i2.capitalizer("student1")));
	}
}
