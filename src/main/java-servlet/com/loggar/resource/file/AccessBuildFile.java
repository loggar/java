package com.loggar.resource.file;

import com.loggar.io.rw.FileInOutSimple;
import com.loggar.io.rw.FileInOutSimpleImpl;

public class AccessBuildFile {
	private static String ver;

	static {
		FileInOutSimple fileInOutSimple = new FileInOutSimpleImpl();
		String filename = "version-info-resources";
		String filepath = Thread.currentThread().getContextClassLoader().getResource(filename).getPath();
		ver = fileInOutSimple.read(filepath);
	}

	private AccessBuildFile() {
		throw new AssertionError(AccessBuildFile.class.getName() + " cannot be instantiable.");
	}

	public static String version() {
		return ver;
	}
}
