package com.loggar.json.tree;

import java.io.File;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.loggar.structure.tree.TreeNode;

public class ConvertToMapTree {
	public static void main(String[] args) {
		try {
			Gson gson = new Gson();
			String jsonString = FileUtils.readFileToString(new File("./dist/json/sample.2.json"), "UTF-8");

			Map<String, Object> map = gson.fromJson(jsonString, new TypeToken<Map<String, Object>>() {
			}.getType());

			System.out.println(map.getClass().toString());
			System.out.println(map);

			// TreeNode<Object> specTreeRoot = new TreeNode<Object>(null);
			// treeMaker(map, specTreeRoot);

			treeViewer(map, null);

			// TraverseTreeIterative.traversePreOrder(specTreeRoot);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean isPrimative(String t) {
		return "string".equals(t) || "integer".equals(t) || "number".equals(t);
	}

	public static void treeMaker(Map<String, Object> e, TreeNode<Object> parent) {
		// todo : make new tree node which values include spec key(_data-key) and options(_data-type..)
		Set<String> keySet = e.keySet();

		for (String key : keySet) {
			TreeNode<Object> node = new TreeNode<Object>(e.get(key));
			parent.addChild(node);

			if (e.get(key).getClass() == LinkedTreeMap.class) {
				@SuppressWarnings("unchecked") Map<String, Object> v = (Map<String, Object>) e.get(key);
				treeMaker((Map<String, Object>) v, node);
			}
		}
	}

	public static void treeViewer(Map<String, Object> e, String pk) {
		Set<String> keySet = e.keySet();

		String type = (String) e.get("_data-type");

		if (pk != null && type != null) {
			System.out.println(pk + " ");
		}

		for (String key : keySet) {

			if (pk != null && isPrimative(type)) {
				System.out.println("  " + key + ":" + e.get(key));
			}

			if (e.get(key).getClass() == LinkedTreeMap.class) {
				@SuppressWarnings("unchecked") Map<String, Object> v = (Map<String, Object>) e.get(key);
				treeViewer((Map<String, Object>) v, key);
			}
		}
	}
}
