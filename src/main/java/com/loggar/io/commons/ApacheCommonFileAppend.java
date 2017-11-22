package com.loggar.io.commons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ApacheCommonFileAppend {
	static File file = new File("./dist/io/append.txt");
	static String fileContent = "This is my 1st message - BufferedWriter Approach \n";
	static String fileContent2 = "This is my 2nd message - Apache Common IO Approach \n";

	public static void main(String[] args) {

		// Method1: Using BufferedWriter - character streams class
		writeToFileBufferedWriter(fileContent);
		writeToFileBufferedWriter(fileContent2);

		// Method2: Using Apache Commons IO
		writeToFileApacheCommonIO(fileContent);
		writeToFileApacheCommonIO(fileContent2);

		System.out.println("File Updated.");
	}

	public static void writeToFileBufferedWriter(String msg) {
		FileWriter fileWriter;
		BufferedWriter bufferedWriter;
		try {
			fileWriter = new FileWriter(file.getAbsoluteFile(), true); // true to append
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(msg);
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeToFileApacheCommonIO(String msg) {
		try {
			// 3rd parameter boolean append = true
			FileUtils.writeStringToFile(file, msg, "UTF-8", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
