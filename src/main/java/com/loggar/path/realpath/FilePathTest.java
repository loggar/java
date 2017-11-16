package com.loggar.path.realpath;

import org.junit.Test;

public class FilePathTest {
	@Test
	public void absPath() {
		String path = this.getClass().getResource("").getPath();
		System.out.println(path);
	}
}
