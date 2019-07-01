package com.loggar.pattern.singleton;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class SingletonEx1Test {
	@Test
	public void singletonInstanceTest() {
		// SingletonEx1 i0 = new SingletonEx1(); // The constructor SingletonEx1() is not visible
		SingletonEx1 i1 = SingletonEx1.getInstance();
		SingletonEx1 i2 = SingletonEx1.getInstance();

		assertTrue(i1 == i2);
		assertTrue(i1.capitalizer("student1").equals(i2.capitalizer("student1")));
	}
}
