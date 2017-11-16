package com.loggar.path.realpath;

import java.io.File;
import java.net.URL;

import org.junit.Test;

public class RealPathTest {
	@Test
	public void test1() {
		URL path1 = this.getClass().getResource("./RealPathTestFile.class");
		System.out.println(path1);

		File file = null;
		try {
			file = new File(path1.getFile());
			System.out.println("file=" + file);
			System.out.println("file.exists()=" + file.exists());
		} catch (Exception e) {
			e.printStackTrace();
		}
		file = null;
	}
}
