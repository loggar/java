package com.loggar.io.filepath;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class FilePaths {
	@Test
	public void pathThisClass() {
		String path = this.getClass().getResource("").getPath() + "test.txt";
		System.out.println(path);
		assertThat(path, is("/C:/Users/webnl/Documents/_workspace_loggar/loggar_java/target/classes/com/loggar/io/path/test.txt"));
	}
}
