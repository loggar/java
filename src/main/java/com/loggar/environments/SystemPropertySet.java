package com.loggar.environments;

import org.junit.jupiter.api.Test;

public class SystemPropertySet {
	@Test
	public void setPropertyTest() {
		String v1 = System.getProperty("NODE_ENV");
		System.out.println(v1);

		// Set a system property
		String b = System.setProperty("NODE_ENV", "something");
		System.out.println(b);

		String b2 = System.setProperty("NODE_ENV", "something2");
		System.out.println(b2);

		String v2 = System.getProperty("NODE_ENV");
		System.out.println(v2);
	}
}
