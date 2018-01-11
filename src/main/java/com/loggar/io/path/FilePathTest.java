package com.loggar.io.path;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

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
		assertThat(path, is("/C:/Users/webnl/Documents/_workspace_loggar/loggar_java/target/classes/com/loggar/practice/path/FilePathTest.class"));
	}
}
