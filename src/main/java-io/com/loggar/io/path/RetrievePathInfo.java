package com.loggar.io.path;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RetrievePathInfo {
	public static void main(String[] args) {
		FileSystem fs = FileSystems.getDefault();
		Iterable<Path> roots = fs.getRootDirectories();
		for (Path root : roots) {
			dumpPathInfo(Paths.get(root.toString(), "a", "b", "c"));
			break;
		}
	}

	static void dumpPathInfo(Path path) {
		System.out.printf("Path: %s%n", path);
		System.out.printf("Filename: %s%n", path.getFileName());
		
		System.out.print("Components Desc: ");
		for (int i = path.getNameCount() - 1; i >= 0; i--) {
			System.out.printf("%s", path.getName(i));
			if(i > 0) System.out.print(", ");
		}
		System.out.print("\n");
		
		System.out.printf("Parent: %s%n", path.getParent());
		System.out.printf("Root: %s%n", path.getRoot());
		System.out.printf("Absolute: %b%n", path.isAbsolute());
		System.out.printf("Subpath [0, 2]: %s%n%n", path.subpath(0, 2));
	}
}
