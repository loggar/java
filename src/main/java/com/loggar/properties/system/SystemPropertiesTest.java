package com.loggar.properties.system;

import java.util.Enumeration;

import org.junit.Test;

public class SystemPropertiesTest {
	@Test
	public void props() {
		java.util.Properties props = System.getProperties();

		Enumeration<Object> keys = props.keys();

		while (keys.hasMoreElements()) {
			Object objTmp = keys.nextElement();
			System.out.println(objTmp + " " + props.get(objTmp));
		}
	}
}
