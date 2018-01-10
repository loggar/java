package com.loggar.tools.number.random;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class RandomInt {
	@Test
	public void randomIntTest() {
		Random rnd = new Random();
		int range = 10;
		int x = -1;

		for (int i = 0; i < 1000; i++) {
			x = rnd.nextInt(range);
			assertTrue(x >= 0 && x < range);
		}
	}
}
