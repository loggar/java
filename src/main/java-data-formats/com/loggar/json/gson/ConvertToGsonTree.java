package com.loggar.json.gson;

import java.io.File;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

public class ConvertToGsonTree {
	public static void main(String[] args) {
		try {
			Gson gson = new Gson();
			String jsonString = FileUtils.readFileToString(new File("./dist/json/sample.2.json"), "UTF-8");

			Map<String, Object> map = gson.fromJson(jsonString, new TypeToken<Map<String, Object>>() {
			}.getType());

			System.out.println(map.getClass().toString());
			System.out.println(map);

			treeView(map, 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void treeView(Map<String, Object> e, int d) {
		Set<String> keySet = e.keySet();

		for (String key : keySet) {
			for (int i = 0; i < d; i++) {
				System.out.print("  ");
			}
			System.out.print(key);

			if (e.get(key).getClass() == LinkedTreeMap.class) {
				@SuppressWarnings("unchecked") Map<String, Object> v = (Map<String, Object>) e.get(key);
				System.out.print(System.lineSeparator());
				treeView((Map<String, Object>) v, d + 1);
			} else {
				Object v = e.get(key);
				System.out.print(": " + v);
				System.out.print(System.lineSeparator());
			}
		}
	}
}
