package com.loggar.json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ReadJsonFile {
	@Test
	public void read() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		String s = "./dist/json/sample.1.json";

		try (InputStream is = new FileInputStream(s); Reader reader = new InputStreamReader(is, "UTF-8")) {
			Gson gson = new GsonBuilder().create();
			Map<String, Object> map = gson.fromJson(reader, new TypeToken<Map<String, String>>() {
			}.getType());
			System.out.println(map);
		}
	}

}
