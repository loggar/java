package com.loggar.json.gson;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConvertToObject {
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
	public void jsonToMap() {
		Gson gson = new Gson();
		String json = "{'a':'a_1','b':'b_1'}";
		Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String, Object>>() {
		}.getType());

		System.out.println(map);
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
		Map<String, Object>[] arrayLikeMap = gson.fromJson(json, new TypeToken<Map<String, Object>[]>() {
		}.getType());
		List<Map<String, Object>> list = Arrays.asList(arrayLikeMap);
		System.out.println(list);
	}

	@Test
	public void jsonToNestedMap() {
		Gson gson = new Gson();
		String json = "{'users': {'id': 9506, 'username': '22222222'}, 'warnings': []}";
		Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String, Object>>() {
		}.getType());

		System.out.println(map);
		System.out.println(map.get("warnings"));

		@SuppressWarnings("unchecked") Map<String, Object> mapNested = (Map<String, Object>) map.get("users");
		System.out.println(mapNested);

		Number strId = (Double) mapNested.get("id");
		System.out.println(strId.intValue());
	}

	@Test
	public void jsonToNestedList() {
		Gson gson = new Gson();
		String json = "{'users': [{'id': 9506, 'username': '333333'}], 'warnings': []}";
		Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String, Object>>() {
		}.getType());

		System.out.println(map.get("users"));

		@SuppressWarnings("unchecked") List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("users");
		System.out.println(list);
	}

	@Test
	public void jsonToNestedList2() {
		Gson gson = new Gson();
		String json = "{'users': [], 'warnings': [{\"warn1\":\"someWarningMsg\"}]}";
		Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String, Object>>() {
		}.getType());

		System.out.println(map.get("users"));

		@SuppressWarnings("unchecked") List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("users");
		System.out.println(list);
	}

}
