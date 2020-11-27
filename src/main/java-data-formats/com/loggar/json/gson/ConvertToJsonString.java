package com.loggar.json.gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

public class ConvertToJsonString {

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
