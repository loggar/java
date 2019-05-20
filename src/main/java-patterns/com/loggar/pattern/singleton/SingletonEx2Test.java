package com.loggar.pattern.singleton;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SingletonEx2Test {
	@Test
	public void singletonInstanceTest() {
		SingletonEx2 i1 = SingletonEx2.INSTANCE;
		SingletonEx2 i2 = SingletonEx2.INSTANCE;

		SingletonEx2 i3 = SingletonEx2.getInstance();
		SingletonEx2 i4 = SingletonEx2.getInstance();

		assertTrue(i1 == i2);
		assertTrue(i1.capitalizer("student1").equals(i2.capitalizer("student1")));

		assertTrue(i3 == i4);
		assertTrue(i3.capitalizer("student1").equals(i4.capitalizer("student1")));
	}
}
