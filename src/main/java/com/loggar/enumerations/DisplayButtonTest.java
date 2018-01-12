package com.loggar.enumerations;

import org.junit.Test;

public class DisplayButtonTest {
	@Test
	public void test1() {
		for(DisplayButton b : DisplayButton.values()) {
			System.out.println("Button: " + b.size());
		}
	}
}
