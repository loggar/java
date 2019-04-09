package com.loggar.numbers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NumberStringConversion {
	@Test
	public void test1() {
		Object n = new Integer(2100);

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
