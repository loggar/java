package com.loggar.java.effective;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * a nonzero-length array is always mutable,
 * so it is wrong for a class to have a public static final array field, or an accessor that returns such a field.
 * @author loggar.lee
 *
 */
public class _12_Accessibility_of_field {
	public static void main(String [] args) {
		System.out.println(display(SomeClass_1.VALUES));
		
		SomeClass_1.VALUES[2] = "newString";
		System.out.println(display(SomeClass_1.VALUES));
		
		List<String> testList = SomeClass_2.VALUES;
		System.out.println(testList);
//		SomeClass_2.VALUES[2] = "newString";
		
		System.out.println(display(SomeClass_3.values()));
//		SomeClass_3.VALUES[2] = "newString";
	}
	
	
	
	static class SomeClass_1 {
		// Potential security hole!
		public static final String[] VALUES = {"a", "b", "c"};
	}
	
	/**
	 * solution 1.
	 * @author loggar.lee
	 *
	 */
	static class SomeClass_2 {
		private static final String[] PRIVATE_FINAL_VALUES = {"a", "b", "c"};
		
		public static final List<String> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_FINAL_VALUES));
	}
	
	/**
	 * solution 2.
	 * @author loggar.lee
	 *
	 */
	static class SomeClass_3 {
		private static final String[] PRIVATE_FINAL_VALUES = {"a", "b", "c"};
		
		public static final String[] values() {
			return PRIVATE_FINAL_VALUES.clone();
		}
	}
	
	public static String display(String [] arr) {
		StringBuffer sb = new StringBuffer();
		sb.setLength(0);
		
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]);
			if(i < arr.length-1) sb.append(", ");
		}
		
		return sb.toString();
	}
}
