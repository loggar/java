package com.loggar.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConvertJson {
	class SomeObj {
		private String a;
		private String b;
		
		public String getA() {
			return a;
		}
		public void setA(String a) {
			this.a = a;
		}
		public String getB() {
			return b;
		}
		public void setB(String b) {
			this.b = b;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("SomeObj [a=").append(a).append(", b=").append(b).append("]");
			return builder.toString();
		}
	}
	
	@Test
	public void objectToJson() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("a", "b");
		list.add(map);

		String json = (new Gson()).toJson(list);
		System.out.println(json);
	}
	
	@Test
	public void jsonToObject() {
		String json = "{'a':'a_1','b':'b_1'}";
		SomeObj obj = (new Gson()).fromJson(json, SomeObj.class);
		System.out.println(obj);
	}
	
	@Test
	public void jsonToList1() {
		String json = "[{'1':'a_1'},{'2':'a_2'}]";
		List<Map<String, Object>> list = (new Gson()).fromJson(json, new TypeToken<List<Map<String, Object>>>() {
		}.getType());
		System.out.println(list);
	}

	@Test
	public void jsonToList2() {
		Gson gson = new Gson();
		String json = "[{'1':'a_1'},{'2':'a_2'}]";
		Map<String, Object>[] arr = gson.fromJson(json, new TypeToken<Map<String, Object>[]>() {
		}.getType());
		List<Map<String, Object>> list = Arrays.asList(arr);
		System.out.println(list);
	}

}
