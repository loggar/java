package com.loggar.json.tree;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loggar.structure.tree.TraverseTreeIterative;
import com.loggar.structure.tree.TreeNode;

public class ConvertToMapTreeTest {
	public static void main(String[] args) {
		String jsonFilePath = "./dist/json/sample.2.json";
		String jsonString = null;

		try {
			jsonString = FileUtils.readFileToString(new File(jsonFilePath), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, Object> map = (new Gson()).fromJson(jsonString, new TypeToken<Map<String, Object>>() {
		}.getType());

		System.out.println(map.getClass().toString());
		System.out.println(map);

		System.out.println("spec-name: " + "some spec name");
		System.out.println("url: " + map.get("url"));

		TreeNode<Map<String, Object>> propsTreeRoot = ConvertToMapTree.init(map);
		TraverseTreeIterative.traversePreOrder(propsTreeRoot);
	}
}
