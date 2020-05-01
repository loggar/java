package com.loggar.numbers;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringNumberConvertTest {
	@Test
	public void test1() {
		Object n = 2100;

		String r = null;

		if (n instanceof Number) {
			r = Integer.toString(((Number) n).intValue());
		} else {
			r = (String) n;
		}

		assertThat(r.equals("2100"), is(true));
	}

	@Test
	public void test2() {
		Object n = "2100";

		String r = null;

		if (n instanceof Number) {
			r = Integer.toString(((Number) n).intValue());
		} else {
			r = (String) n;
		}

		assertThat(r.equals("2100"), is(true));
	}
}
