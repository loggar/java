package com.loggar.io.rw;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class FileRead {
	@Test
	public void readCharData() throws IOException {
		BufferedReader bReader = new BufferedReader(new FileReader("./dist/io/charData.txt"));
		String lineContents;
		while ((lineContents = bReader.readLine()) != null) {
			System.out.println(lineContents);
		}
		bReader.close();
	}

	@Test
	public void readBinaryData() throws IOException {
		DataInputStream inStream = new DataInputStream(new FileInputStream("./dist/io/binaryData.bin"));
		inStream.read();
		
		System.out.println(inStream);
		
		inStream.close();
	}
	
	@Test
	public void readBinaryLargeData() throws IOException {
		DataInputStream inStream = new DataInputStream (new BufferedInputStream(new FileInputStream("./dist/io/binaryData.bin")));
		inStream.read();
		
		System.out.println(inStream);
		
		inStream.close();
	}
}
