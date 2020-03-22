package com.loggar.system;

public class OperatingSystemDependency {
	public static boolean isWindows() {
		boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		return isWindows;
	}
}
