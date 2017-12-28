package com.loggar.effective.instantiation;

/**
 * public static method 조합의 util 클래스는 인스턴스를 생성하거나 상속받지 못하도록 고려하자.
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
