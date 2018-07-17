package com.loggar.resource.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class ReadConfigUsingResourceBundle {
	public static void main(String[] args) {

		try {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("com.loggar.properties.resourcebundle.sample");
			Enumeration<String> keys = resourceBundle.getKeys();
			while (keys.hasMoreElements()) {
				String k = keys.nextElement();
				String v = resourceBundle.getString(k);
				System.out.println(k + ": " + v);
			}

		} catch (Exception e) {
			System.out.println("Error retrieving properties file: " + e);
		}
	}
}
