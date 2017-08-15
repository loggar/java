package com.loggar.reflection.type;

import java.util.HashMap;
import java.util.Map;

public class TypeCheck {
	static class CustomClass {
		private String field1;

		public String getField1() {
			return field1;
		}

		public void setField1(String field1) {
			this.field1 = field1;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("CustomClass [field1=").append(field1).append("]");
			return builder.toString();
		}
	}
	
	public static void main(String[] args) {
//		int data_1 = 1;
//		long data_2 = 2L;
		String data_3 = "sdf";
		Integer data_4 = 3;
		Map<String, Object> data_5 = new HashMap<>();
		CustomClass data_6 = new CustomClass();
		
		Object data_7 = new HashMap<String, Object>();
		
		System.out.println(data_3 instanceof String);
		System.out.println(data_3 instanceof Object);
		System.out.println(data_4 instanceof Integer);
		System.out.println(data_5 instanceof Map);
		System.out.println(data_5 instanceof Object);
		System.out.println(data_6 instanceof CustomClass);
		System.out.println(data_6 instanceof Object);
		System.out.println(data_7 instanceof Map);
		System.out.println(data_7 instanceof Object);
		
	}
}
