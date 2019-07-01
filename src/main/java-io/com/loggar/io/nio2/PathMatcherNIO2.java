package com.loggar.io.nio2;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class PathMatcherNIO2 {
	@Test
	public void pathMatcher() {
		PathMatcher matcher = (Path p) -> {
			// returns boolean
			return (p.toString().contains("Data"));
		};
		
		Path p1 = FileSystems.getDefault().getPath("\\opt\\jpg\\HelloWorld.java");
		System.out.println(p1);
		System.out.print("Matches: " + matcher.matches(p1));
		
		Path p2 = Paths.get("./dist/io/binaryData.bin");
		System.out.println(p2);
		System.out.print("Matches: " + matcher.matches(p2));
	}
}
