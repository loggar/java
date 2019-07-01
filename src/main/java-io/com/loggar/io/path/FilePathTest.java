package com.loggar.io.path;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.net.URL;

import org.junit.jupiter.api.Test;

public class FilePathTest {
	@Test
	public void absPath() {
		String path = this.getClass().getResource("").getPath();
		System.out.println(path);
	}

	@Test
	public void pathThisClass() {
		String path = this.getClass().getResource("").getPath() + "FilePathTest.class";
		System.out.println(path);
		assertThat(path, is(
				"/C:/Users/webnl/Documents/_workspace_loggar/loggar_java/target/classes/com/loggar/io/path/FilePathTest.class"));
	}

	@Test
	public void fileRealPath() {
		URL path1 = this.getClass().getResource("./FilePathTest.class");
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
