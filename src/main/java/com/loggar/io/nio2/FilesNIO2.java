package com.loggar.io.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class FilesNIO2 {
	Path d = Paths.get("./dist/nio2");
	Path target1 = d.resolve(Paths.get("README1.txt"));
	Path target2 = d.resolve(Paths.get("README2.txt"));
	
	@Before
	public void before() throws IOException {
		Files.delete(target1);
		Files.delete(target2);
	}
	
	@Test
	public void files() throws IOException {
		// Create Directory
		Files.createDirectories(d);
		// Intstantiate path objects
		
		System.out.println(target1);
		Path p1 = Files.createFile(target1);
		System.out.println(p1);
		
		System.out.println(target2);
		Path p2 = Files.createFile(target2);
		System.out.println(p2);
		// Check file attributes
		System.out.println(Files.isReadable(p1));
		System.out.println(Files.isReadable(p2));
		System.out.println(Files.isExecutable(p1));
		System.out.println(Files.isSymbolicLink(p1));
		System.out.println(Files.isWritable(p1));
		System.out.println(Files.isHidden(p1));
		System.out.println(Files.isSameFile(p1, p2));
		// Delete, move, and copy examples
		Files.delete(p2);
		System.out.println(Files.move(p1, p2));
		System.out.println(Files.copy(p2, p1));
	}
}
