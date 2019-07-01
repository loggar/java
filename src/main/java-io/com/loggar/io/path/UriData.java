package com.loggar.io.path;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class UriData {
	@Test
	public void test() throws URISyntaxException {
		// get URI of class
		String clazz = "./UriData.class";

		URI resourceURI = this.getClass().getResource(clazz).toURI();
		System.out.println("resourceURI.getScheme(): " + resourceURI.getScheme());
		System.out.println("resourceURI.getRawSchemeSpecificPart(): " + resourceURI.getRawSchemeSpecificPart());
		URI fileURI = new URI(resourceURI.getRawSchemeSpecificPart());
		System.out.println("fileURI.getScheme(): " + fileURI.getScheme());
		System.out.println("fileURI.getRawSchemeSpecificPart(): " + fileURI.getRawSchemeSpecificPart());

		String filePath = fileURI.toString();
		Path path = Paths.get(filePath.substring(1, filePath.length())); // if windows system.
		System.out.println("path: " + path);
		System.out.println("path.getParent(): " + path.getParent());
	}
}
