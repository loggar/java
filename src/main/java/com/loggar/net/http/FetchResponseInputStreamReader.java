package com.loggar.net.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class FetchResponseInputStreamReader {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://google.com/");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String strTemp = "";
			while (null != (strTemp = br.readLine())) {
				System.out.println(strTemp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
