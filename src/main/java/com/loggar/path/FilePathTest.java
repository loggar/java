package com.loggar.path;

import org.junit.Test;

public class FilePathTest {
	@Test
	public void absPath() {
		String path = this.getClass().getResource("").getPath();
		System.out.println(path);
	}
}
