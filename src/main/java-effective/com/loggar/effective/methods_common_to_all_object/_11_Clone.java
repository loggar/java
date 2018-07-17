package com.loggar.effective.methods_common_to_all_object;

/**
 * Override clone judiciously
 * 
 */
public class _11_Clone {
	public static void main(String [] args) {
		PhoneNumber testObject1 = new PhoneNumber(123, 456, 7890);
		PhoneNumber testObject2= testObject1.clone();
		
		System.out.println(testObject1 == testObject2);
		System.out.println(testObject1.equals(testObject2));
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
		
		@Override public boolean equals(Object o) {
			if(o == this) return true;
			if(!(o instanceof PhoneNumber)) return false;
			
			PhoneNumber pn = (PhoneNumber) o;
			
			return pn.areaCode == areaCode
					&& pn.prefixNumber == prefixNumber
					&& pn.lineNumber == lineNumber;
		}
		
		/**
		 * Lazily initialized, cached hashCode, See Item 71
		 */
		private volatile int hashCode;
		
		@Override public int hashCode() {
			int result = hashCode;
			if(result == 0) {
				result = 17;
				result = 31*result + areaCode;
				result = 31*result + prefixNumber;
				result = 31*result + lineNumber;
				
				hashCode = result;
			}
			return result;
		}
		
		/*
		@Override public int hashCode() {
			int result = 17;
			result = 31*result + areaCode;
			result = 31*result + prefixNumber;
			result = 31*result + lineNumber;
			
			hashCode = result;
		}
		*/
		
		@Override public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.setLength(0);
			sb.append("PhoneNumber={").append(areaCode).append('-').append(prefixNumber).append('-').append(lineNumber).append('}');
			
			return sb.toString();
		}
		
		@Override public PhoneNumber clone() {
			PhoneNumber newInstance = new PhoneNumber(areaCode, prefixNumber, lineNumber);
			return newInstance;
		}
	}
}
