package com.loggar.practice.path;

import java.io.File;
import java.net.URL;

import org.junit.Test;

public class RealPathTest {
	@Test
	public void test1() {
		URL path1 = this.getClass().getResource("./RealPathTest.class");
		System.out.println(path1);

		File file = null;
		String filePath = null;

		try {
			filePath = path1.getFile();
			file = new File(filePath);
			System.out.println("file=" + file);
			System.out.println("file.exists()=" + file.exists());
		} catch (Exception e) {
			e.printStackTrace();
		}
		file = null;
	}
}
