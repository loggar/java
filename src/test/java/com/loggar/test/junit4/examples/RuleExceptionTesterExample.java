package com.loggar.test.junit4.examples;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class RuleExceptionTesterExample {
	@Rule public TemporaryFolder folder = new TemporaryFolder();

	// JUnit already provides several useful rule implementations.
	// For example, the TemporaryFolder class allows to setup files and folders which are automatically removed after each test run.

	@Test
	public void testUsingTempFolder() throws IOException {
		File createdFolder = folder.newFolder("newfolder");
		File createdFile = folder.newFile("myfilefile.txt");
		System.out.println(createdFolder);
		assertTrue(createdFile.exists());
	}
}
