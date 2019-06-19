package com.loggar.tools.common;

public class Variables {
	private Variables() {
		throw new AssertionError(Variables.class.getName() + " cannot be instantiable.");
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
		return 8; // default for 64-bit memory pointer
	}
}
