package com.loggar.exercise.system;

public class DitermineSystemArchitecture {
	public static void main(String[] args) {
		System.out.println(System.getProperty("sun.arch.data.model"));

		boolean is64Arch = System.getProperty("sun.arch.data.model").equals("64");
		System.out.println("64bit arch: " + is64Arch);
	}
}
