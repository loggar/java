package com.loggar.environments;

import java.util.Enumeration;

import org.junit.jupiter.api.Test;

public class SystemPropertiesGet {
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
