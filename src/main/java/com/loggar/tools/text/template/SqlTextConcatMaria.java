package com.loggar.tools.text.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SqlTextConcatMaria {
	public static void main(String [] args) {
		Path p1 = Paths.get("./dist/tools/text/sql.txt");
		String path = p1.toString();
		
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
