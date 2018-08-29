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

	@Test
	public void objectToJson() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("a", "b");
		list.add(map);

		String json = (new Gson()).toJson(list);
		System.out.println(json);
	}
}
