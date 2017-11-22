package com.loggar.io.convert;

import java.io.File;
import java.io.FileInputStream;

public class FileToByteStream {
	public static void main(String[] args) {

		FileInputStream inputStream = null;

		File file = new File("./dist/io/append.txt");

		byte[] byteStream = new byte[(int) file.length()];

		try {

			inputStream = new FileInputStream(file);
			inputStream.read(byteStream);
			inputStream.close();

			for (int counter = 0; counter < byteStream.length; counter++) {
				System.out.print((char) byteStream[counter]);
			}

			System.out.println("\nTask Finished");
		} catch (Exception e) {
			logError("Exception" + e);
		}
	}

	private static void logError(String string) {
		System.out.println(string);

	}
}
