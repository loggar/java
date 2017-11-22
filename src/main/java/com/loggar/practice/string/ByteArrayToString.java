package com.loggar.practice.string;

import java.io.UnsupportedEncodingException;

public class ByteArrayToString {
	public static void main(String[] args) {
		String testString = "Sample Example on Byte[] to String";
		byte[] bytesData = testString.getBytes();

		System.out.println("testString : " + testString);
		System.out.println("bytesData : " + bytesData); // .getBytes on String will return Hashcode value
		System.out.println("bytesData.toString() : " + bytesData.toString()); // .toString() will return Hashcode value

		String decodedData = new String(bytesData); // Create new String Object and assign byte[] to it
		System.out.println("Text Decryted : " + decodedData);
		String decodedDataUsingUTF8;
		try {
			decodedDataUsingUTF8 = new String(bytesData, "UTF-8"); // Best way to decode using "UTF-8"
			System.out.println("Text Decryted using UTF-8 : " + decodedDataUsingUTF8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
