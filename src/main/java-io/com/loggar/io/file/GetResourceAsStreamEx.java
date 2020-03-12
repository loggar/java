package com.loggar.io.file;

import java.net.URL;

public class GetResourceAsStreamEx {
	public static void main(String args[]) {
		URL path = GetResourceAsStreamEx.class.getResource("./GetResourceAsStreamEx.class");

		System.out.println(path);
	}
}
