package com.loggar.java.effective;

import java.util.HashMap;
import java.util.Map;

/**
 * 08. Obey the general contract when overring equals
 * 09. Always override hashCode when you override equals
 * 
 * @author loggar.lee
 *
 */
public class _08_Equals_HashCode {
	public static void main(String [] args) {
		Map<PhoneNumber, String> map = new HashMap<>();
		
		map.put(new PhoneNumber(123, 456, 7890), "Charly");
		
		/*
		 * and now with the proper hashCode, I can use PhoneNumber instance as an key of Map.
		 */
		System.out.println(map.get(new PhoneNumber(123, 456, 7890)));
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
	}
}
