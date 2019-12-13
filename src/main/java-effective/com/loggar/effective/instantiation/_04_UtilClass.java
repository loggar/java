package com.loggar.effective.instantiation;

/**
 * Prevent Class-Instantiation of Util Classes that are only compose to public static methods.
 *
 */
public class _04_UtilClass {
	public static void main(String [] args) {
		System.out.println(SomeUtil.getSomeString());
		
		@SuppressWarnings("unused")
		SomeUtil a = new SomeUtil();
		
		System.out.println(SomeUtil.getSomeString());
	}
	
	static final class SomeUtil {
		private SomeUtil() {
			throw new AssertionError();
		}
		
		public static String getSomeString() {
			return "New String";
		}
	}
	
	/*
	static class SomeUtilChild extends SomeUtil {
		
	}
	*/
}
