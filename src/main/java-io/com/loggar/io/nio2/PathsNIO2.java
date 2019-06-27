package com.loggar.io.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class PathsNIO2 {
	@Test
	public void paths() {
		Path p = Paths.get("./dist/io/binarydata.bin");
		System.out.println(p.getParent());
		System.out.println(p.getRoot());
		System.out.println(p.getNameCount());
		System.out.println(p.getName(0));
		System.out.println(p.getName(1));
		System.out.println(p.getFileName());
		System.out.println(p.toString());
		System.out.println(p.toUri());
		System.out.println(p.resolve(Paths.get("./subDrectory/subFile")));
		System.out.println(p.relativize(Paths.get("./dist/.tmp/transient/TransientSample")));
		System.out.println(p.compareTo(Paths.get("./dist/.tmp/transient/TransientSample")));
	}
}
