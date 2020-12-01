package com.loggar.json.tree;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.loggar.structure.tree.TraverseTreeIterative;
import com.loggar.structure.tree.TreeNode;

public class ConvertToMapTree {
	public static void main(String[] args) throws IOException {
		try {
			String jsonString = FileUtils.readFileToString(new File("./dist/json/sample.2.json"), "UTF-8");

			Map<String, Object> map = (new Gson()).fromJson(jsonString, new TypeToken<Map<String, Object>>() {
			}.getType());

			// System.out.println(map.getClass().toString());
			// System.out.println(map);

			System.out.println("spec-name: " + "some spec name");
			System.out.println("url: " + map.get("url"));

			TreeNode<Map<String, Object>> propsTreeRoot = treeMaker((LinkedTreeMap<String, Object>) map);
			TraverseTreeIterative.traversePreOrder(propsTreeRoot);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean isNodeTypePrimative(String t) {
		return !"object".equals(t) && !"list".equals(t);
	}

	/**
	 * Make a tree for the given json spec
	 * 
	 * @param e
	 * @return
	 */
	public static TreeNode<Map<String, Object>> treeMaker(LinkedTreeMap<String, Object> e) {
		TreeNode<Map<String, Object>> rootNode = treeMaker(e, null, null);
		traverseSetInfoType(rootNode, "root");
		return rootNode;
	}

	/**
	 * Tree Factory for a json spec
	 * 
	 * @param e
	 * @param pk
	 * @param parent
	 * @return
	 */
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
			props.put("_info-type", (String) e.get("_info-type"));
			@SuppressWarnings("unchecked") LinkedTreeMap<String, Object> v = (LinkedTreeMap<String, Object>) e.get("properties");
			Set<String> subKeySet = v.keySet();
			for (String subKey : subKeySet) {
				@SuppressWarnings("unchecked") LinkedTreeMap<String, Object> sv = (LinkedTreeMap<String, Object>) v.get(subKey);
				treeMaker(sv, subKey, node);
			}
		}

		return node;
	}

	/**
	 * Fill nodes' empty _info-type, Pre order
	 * 
	 * @param <T>
	 * @param node
	 * @param _infoType
	 */
	public static <T> void traverseSetInfoType(TreeNode<Map<String, Object>> node, String _infoType) {
		if (node == null)
			return;

		Map<String, Object> v = node.getValue();
		String infoType = (String) v.get("_info-type");

		System.out.print("visit " + v.get("_data-nm") + " infoType=" + infoType);

		if (infoType != null) {
			_infoType = infoType;
			System.out.print(" now _infoType=" + _infoType);
		} else {
			v.put("_info-type", _infoType);
			System.out.print(" update infoType=" + _infoType);
		}

		System.out.print(System.lineSeparator());

		List<TreeNode<Map<String, Object>>> children = node.getChildren();
		for (TreeNode<Map<String, Object>> c : children) {
			traverseSetInfoType(c, _infoType);
		}
	}
}
