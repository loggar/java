package com.loggar.io.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class ReadStreamApacheCommons {
	public static void main(String[] args) throws IOException {
		String filepath = "C:\\Users\\webnl\\Documents\\_workspace_java\\loggar_java\\dist\\json\\sample.1.json";

		LineIterator it = FileUtils.lineIterator(new File(filepath));
		try {
			while (it.hasNext()) {
				String line = it.nextLine();
				System.out.println(line);
			}
		} finally {
			it.close();
		}
	}

}
