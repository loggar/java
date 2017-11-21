package com.loggar.effective;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author loggar.lee
 *
 * @param <T>
 */
public class _11_Comparable {
	public static void main(String [] args) {
		PhoneNumber testObject1 = new PhoneNumber(123, 456, 7890);
		PhoneNumber testObject2= new PhoneNumber(123, 457, 7890);
		PhoneNumber testObject3= new PhoneNumber(125, 456, 7890);
		PhoneNumber testObject4 = new PhoneNumber(123, 456, 7899);
		
		PhoneNumber [] arr1 = new PhoneNumber[4];
		arr1[0] = testObject1;
		arr1[1] = testObject2;
		arr1[2] = testObject3;
		arr1[3] = testObject4;
		display(arr1);
		
		Arrays.sort(arr1);
		display(arr1);
		
		PhoneNumber [] arr2 = new PhoneNumber[4];
		arr2[0] = testObject1;
		arr2[1] = testObject2;
		arr2[2] = testObject3;
		arr2[3] = testObject4;
		display(arr2);
		
		Set<PhoneNumber> set = new TreeSet<>();
		Collections.addAll(set, arr2);
		System.out.println(set);
		
	}
	
	static void display(PhoneNumber [] arr) {
		for(PhoneNumber p : arr) System.out.println(p);
		System.out.println("--------------------------");
	}
		
	static class PhoneNumber implements Comparable<PhoneNumber> {
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

		/*
		@Override
		public int compareTo(PhoneNumber o) {
			if(areaCode < o.areaCode) return -1;
			if(areaCode > o.areaCode) return 1;
			if(prefixNumber < o.prefixNumber) return -1;
			if(prefixNumber > o.prefixNumber) return 1;
			if(lineNumber < o.lineNumber) return -1;
			if(lineNumber > o.lineNumber) return 1;
			return 0;
		}
		*/
		
		/*
		 * faster version.
		 */
		@Override
		public int compareTo(PhoneNumber o) {
			int areaCodeDiff = areaCode - o.areaCode;
			if(areaCodeDiff != 0) return areaCodeDiff;
			
			int prefixNumberDiff = prefixNumber - o.prefixNumber;
			if(prefixNumberDiff != 0) return prefixNumberDiff;
			
			return lineNumber - o.lineNumber;
		}
	}
}
