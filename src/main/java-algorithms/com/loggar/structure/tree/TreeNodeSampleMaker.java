package com.loggar.structure.tree;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class TreeNodeSampleMaker {
	public static TreeNode<Map<String, Object>> jsonTree(JsonElement e) {
		if (e.isJsonNull()) {
			System.out.println(e.toString());
		}

		if (e.isJsonPrimitive()) {
			System.out.println(e.toString());
		}

		if (e.isJsonArray()) {
			JsonArray ja = e.getAsJsonArray();
			if (null != ja) {
				for (JsonElement ae : ja) {
					jsonTree(ae);
				}
			}
		}

		if (e.isJsonObject()) {
			Set<Entry<String, JsonElement>> es = e.getAsJsonObject().entrySet();
			for (Entry<String, JsonElement> en : es) {
				System.out.println(en.getKey() + ": ");
				jsonTree(en.getValue());
			}
		}
		
		
		return null;
	}
}
