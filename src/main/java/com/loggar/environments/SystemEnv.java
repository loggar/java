package com.loggar.environments;

public class SystemEnv {
	public static void main(String[] args) throws Exception {
		System.out.println("System.getenv(\"TEMP\") = " + System.getenv("TEMP"));
		System.out.println("System.getenv(\"USERNAME\") = " + System.getenv("USERNAME"));
		System.out.println("System.getenv(\"JAVA_HOME\") = " + System.getenv("JAVA_HOME"));
	}
}
