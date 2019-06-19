package com.loggar.tools.common;

public class VariablesUsage {
	public static void main(String args[]) {
		System.out.println(" size of byte in Java is (in bytes) :  " + Variables.sizeof(byte.class));
		System.out.println(" size of short in Java is (in bytes) :" + Variables.sizeof(short.class));
		System.out.println(" size of char in Java is (in bytes) :" + Variables.sizeof(char.class));
		System.out.println(" size of int in Java is (in bytes) :" + Variables.sizeof(int.class));
		System.out.println(" size of long in Java is (in bytes) :" + Variables.sizeof(long.class));
		System.out.println(" size of float in Java is (in bytes) :" + Variables.sizeof(float.class));
		System.out.println(" size of double in Java is (in bytes) :" + Variables.sizeof(double.class));
	}
}
