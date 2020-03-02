package com.loggar.tools.common;

public class VariablesSizeof {
	private VariablesSizeof() {
		throw new AssertionError(VariablesSizeof.class.getName() + " cannot be instantiable.");
	}

	public static int sizeof(final Class<?> dataType) {
		if (dataType == null) {
			throw new NullPointerException();
		}
		if (dataType == byte.class || dataType == Byte.class) {
			return Byte.SIZE;
		}
		if (dataType == short.class || dataType == Short.class) {
			return Short.SIZE;
		}
		if (dataType == char.class || dataType == Character.class) {
			return Character.SIZE;
		}
		if (dataType == int.class || dataType == Integer.class) {
			return Integer.SIZE;
		}
		if (dataType == long.class || dataType == Long.class) {
			return Long.SIZE;
		}
		if (dataType == float.class || dataType == Float.class) {
			return Float.SIZE;
		}
		if (dataType == double.class || dataType == Double.class) {
			return Double.SIZE;
		}

		if (System.getProperty("sun.arch.data.model").equals("64")) {
			return 8; // default for 64-bit memory pointer
		} else {
			return 4; // default for 32-bit memory pointer
		}
	}

	public static void main(String args[]) {
		System.out.println(" size of byte in Java is (in bytes) :  " + VariablesSizeof.sizeof(byte.class));
		System.out.println(" size of short in Java is (in bytes) :" + VariablesSizeof.sizeof(short.class));
		System.out.println(" size of char in Java is (in bytes) :" + VariablesSizeof.sizeof(char.class));
		System.out.println(" size of int in Java is (in bytes) :" + VariablesSizeof.sizeof(int.class));
		System.out.println(" size of long in Java is (in bytes) :" + VariablesSizeof.sizeof(long.class));
		System.out.println(" size of float in Java is (in bytes) :" + VariablesSizeof.sizeof(float.class));
		System.out.println(" size of double in Java is (in bytes) :" + VariablesSizeof.sizeof(double.class));
	}
}
