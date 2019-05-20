package com.loggar.pattern.singleton;

/**
 * Simple example of stateless object.
 *
 */
public class StatelessObject {
	public String capitalizer(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
