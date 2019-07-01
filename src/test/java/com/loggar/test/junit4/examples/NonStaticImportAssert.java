package com.loggar.test.junit4.examples;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class NonStaticImportAssert {
	@Test
	public void test1() {
		Assert.assertEquals("10 x 5 must be 50", 10 * 5, 50);
	}
}
