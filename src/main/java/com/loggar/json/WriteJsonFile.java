package com.loggar.json;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WriteJsonFile {
	// @Test
	public void write() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		String s = "./dist/json/sample.1.json";

		Map<String, Object> map = new HashMap<>();
		map.put("status", "processing");
		map.put("file", "sample.xlsx");
		map.put("insUid", "charly");
		map.put("email", "sample@domain.com");
		map.put("reportDate", "11/07/2018");

		try (Writer writer = new OutputStreamWriter(new FileOutputStream(s), "UTF-8")) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(map, writer);
		}
	}

	@Test
	public void write_stream() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		String s = "./dist/json/sample.1.json";

		Map<String, Object> map = new HashMap<>();
		map.put("status", "processing");
		map.put("file", "sample.xlsx");
		map.put("insUid", "charly");
		map.put("email", "sample@domain.com");
		map.put("reportDate", "11/07/2018");

		try (Writer writer = new OutputStreamWriter(new FileOutputStream(s), "UTF-8")) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(map, writer);
		}
	}

}
