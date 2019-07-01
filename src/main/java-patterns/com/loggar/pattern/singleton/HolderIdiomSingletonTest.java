package com.loggar.pattern.singleton;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class HolderIdiomSingletonTest {
	@Test
	public void singletonTest() {
		HolderIdiomSingleton singletonInstance = HolderIdiomSingleton.getInstance();
		HolderIdiomSingleton singletonInstance2 = HolderIdiomSingleton.getInstance();
		assertTrue(singletonInstance == singletonInstance2);
	}
}
