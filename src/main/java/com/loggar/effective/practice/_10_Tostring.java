package com.loggar.effective.practice;

/**
 * 10. Always override toString
 * 
 */
public class _10_Tostring {
	public static void main(String [] args) {
		PhoneNumber testObject1 = new PhoneNumber(123, 456, 7890);
		
		System.out.println(testObject1);
	}
	
	static class PhoneNumber {
		private final short areaCode;
		private final short prefixNumber;
		private final short lineNumber;
		
		public PhoneNumber(short a, short b, short c) {
			this.areaCode = a;
			this.prefixNumber = b;
			this.lineNumber = c;
		}
		
		public PhoneNumber(int a, int b, int c) {
			this.areaCode = (short) a;
			this.prefixNumber = (short) b;
			this.lineNumber = (short) c;
		}
		
		@Override public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.setLength(0);
			sb.append("PhoneNumber={").append(areaCode).append('-').append(prefixNumber).append('-').append(lineNumber).append('}');
			
			return sb.toString();
		}
	}
}
