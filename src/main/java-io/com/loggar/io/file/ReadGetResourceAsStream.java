package com.loggar.io.file;

import java.net.URL;

public class ReadGetResourceAsStream {
	public static void main(String args[]) {
		URL path = ReadGetResourceAsStream.class.getResource("./GetResourceAsStreamEx.class");

		System.out.println(path);
	}
}
