package com.loggar.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyFunction {
	public static void main(String[] args) {
		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			File file1 = new File("./dist/io/f1");
			File file2 = new File("./dist/io/f1_copy");

			inStream = new FileInputStream(file1);
			outStream = new FileOutputStream(file2); // for override file content
			// outStream = new FileOutputStream(file2,<strong>true</strong>); // for append file content

			byte[] buffer = new byte[1024];

			int length;
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}

			if (inStream != null)
				inStream.close();
			if (outStream != null)
				outStream.close();

			System.out.println("File Copied..");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
