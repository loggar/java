package com.loggar.json.gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class TraverseGsonTree {
	public static String encodeValue(String value) {
		try {
			return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException(ex.getCause());
		}
	}

	public JsonElement traverse(JsonElement element) {
		if (element.isJsonPrimitive()) {
			JsonPrimitive primitive = element.getAsJsonPrimitive();
			if (primitive != null && primitive.isString()) {
				return new JsonPrimitive(encodeValue(primitive.getAsString())); // You can use any other encoding function as well!
			} else {
				return primitive;
			}
		} else if (element.isJsonArray()) {
			JsonArray jsonArray = element.getAsJsonArray();
			JsonArray cleanedNewArray = new JsonArray();
			for (JsonElement jsonElement : jsonArray) {
				cleanedNewArray.add(traverse(jsonElement));
			}
			return cleanedNewArray;
		} else if (element.isJsonNull()) {
			return element.getAsJsonNull();
		} else {
			JsonObject obj = element.getAsJsonObject();
			JsonObject encodedJsonObject = new JsonObject();
			for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
				encodedJsonObject.add(encodeValue(entry.getKey()), traverse(entry.getValue()));
			}
			return encodedJsonObject;
		}
	}
}
