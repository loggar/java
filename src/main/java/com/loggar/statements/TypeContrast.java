package com.loggar.statements;

public class TypeContrast {
	public static void main(String [] args) {
		char[] arr_c = {'a','b','c'};
		Object string2_01 = new String2(arr_c);
		System.out.println(string2_01.toString());
		System.out.println(string2_01.getClass());
		
		String2 string2_02 = new String2(arr_c);
		System.out.println(string2_02.toString());
		System.out.println(string2_02.getClass());
		System.out.println(string2_02 == string2_01);
		
		String2 string2_03 = safeInstance(string2_02);
		System.out.println(string2_03.toString());
		System.out.println(string2_03.getClass());
		System.out.println(string2_03 == string2_02);
	}
	
	private static String2 safeInstance(String2 val) {
		if(val.getClass() != String2.class) return new String2(val.getData());
		return val;
	}
	
	static class String2 extends Object {
		private final char[] data;
		
		public String2(char[] data) {
			this.data = data.clone();
		}
		
		public char[] getData() {
			return this.data.clone();
		}
		
		public String toString() {
			return new String(this.data);
		}
	}
}
