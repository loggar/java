package com.loggar.json.gson;

import java.io.File;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConvertJsonTree {
	public static void main(String[] args) {
		try {
			String jsonString = FileUtils.readFileToString(new File("./dist/json/sample.2.json"), "UTF-8");

			// JsonParser deprecated
			// JsonParser p = new JsonParser();
			// JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
			// JsonElement e = p.parse(jsonString);

			JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
			System.out.println(jsonObject);

			JsonElement jsonElement = JsonParser.parseString(jsonString);
			jsonTree(jsonElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void jsonTree(JsonElement e) {
		if (e.isJsonNull()) {
			System.out.println(e.toString());
			return;
		}

		if (e.isJsonPrimitive()) {
			System.out.println(e.toString());
			return;
		}

		if (e.isJsonArray()) {
			JsonArray ja = e.getAsJsonArray();
			if (null != ja) {
				for (JsonElement ae : ja) {
					jsonTree(ae);
				}
			}
			return;
		}

		if (e.isJsonObject()) {
			Set<Entry<String, JsonElement>> es = e.getAsJsonObject().entrySet();
			for (Entry<String, JsonElement> en : es) {
				System.out.println("\"" + en.getKey() + "\": ");
				jsonTree(en.getValue());
			}
		}
	}

}
