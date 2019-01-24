package com.loggar.strings;

import org.junit.Test;

public class StringFeatures {
	@Test
	public void join() {
		String [] arr = {"a", "b", "c"};
		String s = String.join(", ", arr);
		System.out.println(s);
	}
}
