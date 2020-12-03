package com.loggar.json.tree;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loggar.structure.tree.TraverseTreeIterative;
import com.loggar.structure.tree.TreeNode;

public class JsonSpecTreeConvertorTest {
	private static final Logger logger = LoggerFactory.getLogger(JsonSpecTreeConvertorTest.class);

	JsonSpecTreeConvertor jsonSpecTreeConvertor = new JsonSpecTreeConvertor();

	@Test
	public void convert_sample_json_to_tree() {
		String jsonFilePath = "./dist/json/sample.2.json";
		String jsonString = null;

		try {
			jsonString = FileUtils.readFileToString(new File(jsonFilePath), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, Object> map = (new Gson()).fromJson(jsonString, new TypeToken<Map<String, Object>>() {
		}.getType());

		logger.debug(map.getClass().toString());
		logger.debug("map {}", map);

		logger.debug("spec-name: {}", "some spec name");
		logger.debug("url: {}", map.get("url"));

		TreeNode<Map<String, Object>> propsTreeRoot = jsonSpecTreeConvertor.convert(map);
		TraverseTreeIterative.traversePreOrder(propsTreeRoot);

		assertTrue(jsonSpecTreeConvertor.countDataNode(propsTreeRoot) == 7);
	}

	public static void main(String[] args) {
		JsonSpecTreeConvertorTest jsonSpecTreeConvertorTest = new JsonSpecTreeConvertorTest();
		jsonSpecTreeConvertorTest.convert_sample_json_to_tree();
	}
}
