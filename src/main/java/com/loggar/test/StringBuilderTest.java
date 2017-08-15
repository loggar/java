package com.loggar.test;

import org.junit.Test;

public class StringBuilderTest {
	@Test
	public void test2() {
		StringBuilder sb = new StringBuilder(); sb.setLength(0);
		
		sb.append(213).append(",");
		sb.append(456).append(",");
		
		System.out.println("[" + sb.substring(0, sb.length() -1) + "]");
	}
}
