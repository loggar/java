package com.loggar.io.convert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVtoArrayList {
	public static void main(String[] args) {
		BufferedReader buffer = null;

		try {
			String line;
			buffer = new BufferedReader(new FileReader("./dist/io/sample.csv"));

			// How to read file in java line by line?
			while ((line = buffer.readLine()) != null) {
				System.out.println("Raw CSV data: " + line);
				System.out.println("Converted ArrayList data: " + csvtoArrayList(line) + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffer != null)
					buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Utility which converts CSV to ArrayList using Split Operation
	public static ArrayList<String> csvtoArrayList(String csv) {
		ArrayList<String> result = new ArrayList<String>();

		if (csv != null) {
			String[] splitData = csv.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					result.add(splitData[i].trim());
				}
			}
		}

		return result;
	}
}
