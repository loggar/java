package com.loggar.pattern.singleton;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ThreadSafeSingletonTest {
	@Test
	public void test() {
		ThreadSafeSingleton o1 = ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton o2 = ThreadSafeSingleton.getInstance();

		assertTrue(o1 == o2);
	}
}
