package com.loggar.io.resource;

import java.io.File;
import java.net.URL;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetResourceFromClasspath {
	@Test
	public void getFile() {
		URL fileUrl = getClass().getResource("/logback.xml");
		File file = new File(fileUrl.getFile());
		Assertions.assertEquals("logback.xml", file.getName());
	}
}
