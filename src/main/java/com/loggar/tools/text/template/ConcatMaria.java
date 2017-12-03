package com.loggar.tools.text.template;

import java.io.BufferedReader;
import java.io.FileReader;

public class ConcatMaria {
	public static void main(String [] args) {
		String path = ConcatMaria.class.getResource("").getPath() + "sql.txt";
		
		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		
		try {
			String lineContents;
			BufferedReader bReader = new BufferedReader(new FileReader(path));
			while ((lineContents = bReader.readLine()) != null) {
				sb.append(lineContents).append(System.lineSeparator());
			}
			bReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String s = sb.substring(0, sb.lastIndexOf(System.lineSeparator()));
		
		String pre = "CONCAT(";
		String post = ")";
		
		String result = pre + s.replaceAll("\\+", ",") + post;
		
		System.out.print(result);
	}
}
