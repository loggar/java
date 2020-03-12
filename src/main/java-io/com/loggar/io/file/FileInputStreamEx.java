package com.loggar.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputStreamEx {
	public static void main(String[] args) throws FileNotFoundException {
		String filepath = "C:\\Users\\webnl\\Documents\\_workspace_java\\loggar_java\\dist\\json\\sample.1.json";

		InputStream is = new FileInputStream(new File(filepath));

		System.out.println(is);
	}
}
