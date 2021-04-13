package com.loggar.io.rw;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileInOutSimpleImpl implements FileInOutSimple {
	@Override
	public void write(String filePath, Object data) {
		String writeData = new String((String) data);
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(filePath);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true);
			pw.write(writeData);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
			pw = null;
			try {
				bw.close();
				bw = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fw.close();
				fw = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String read(String filePath) {
		StringBuilder sb = new StringBuilder(0);
		InputStream is = null;
		Scanner scanner = null;
		try {
			is = new FileInputStream(filePath);
			scanner = new Scanner(is);
			while (scanner.hasNextLine()) {
				sb.append(scanner.nextLine() + ' ');
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}