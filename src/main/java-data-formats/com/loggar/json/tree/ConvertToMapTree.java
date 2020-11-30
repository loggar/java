package com.loggar.json.tree;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.loggar.structure.tree.TraverseTreeIterative;
import com.loggar.structure.tree.TreeNode;

public class ConvertToMapTree {
	public static void main(String[] args) {
		try {
			Gson gson = new Gson();
			String jsonString = FileUtils.readFileToString(new File("./dist/json/sample.2.json"), "UTF-8");

			Map<String, Object> map = gson.fromJson(jsonString, new TypeToken<Map<String, Object>>() {
			}.getType());

			// System.out.println(map.getClass().toString());
			System.out.println(map);

			LinkedTreeMap<String, Object> properties = (LinkedTreeMap<String, Object>) map;

			TreeNode<Map<String, Object>> propsTreeRoot = treeMaker(properties, null, null);
			// treeMaker(map, specTreeRoot);

			TraverseTreeIterative.traversePreOrder(propsTreeRoot);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean isNodeTypePrimative(String t) {
		return !"object".equals(t) && !"list".equals(t);
	}

	// tmp view for treeMaker?
	public static TreeNode<Map<String, Object>> treeMaker(LinkedTreeMap<String, Object> e, String pk, TreeNode<Map<String, Object>> parent) {
		String dataType = (String) e.get("_data-type");
		if (pk == null) {
			pk = "root";
			dataType = "object";
		}

		Map<String, Object> props = new HashMap<>();
		props.put("_data-nm", pk);

		TreeNode<Map<String, Object>> node = new TreeNode<>(props);
		if (parent != null) {
			parent.addChild(node);
			props.put("_parent-nm", parent.getValue().get("_data-nm"));
		}

		if (isNodeTypePrimative(dataType)) {
			Set<String> keySet = e.keySet();
			for (String key : keySet) {
				if (!"properties".equals(key)) {
					props.put(key, e.get(key));
				}
			}
		} else {
			props.put("_data-type", dataType);
			@SuppressWarnings("unchecked") LinkedTreeMap<String, Object> v = (LinkedTreeMap<String, Object>) e.get("properties");
			Set<String> subKeySet = v.keySet();
			for (String subKey : subKeySet) {
				@SuppressWarnings("unchecked") LinkedTreeMap<String, Object> sv = (LinkedTreeMap<String, Object>) v.get(subKey);
				treeMaker(sv, subKey, node);
			}
		}

		return node;
	}
}
