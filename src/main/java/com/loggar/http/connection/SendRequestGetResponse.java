package com.loggar.http.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class SendRequestGetResponse {
	public static void main(String[] args) {
		String url = "http://www.mocky.io/v2/5a165cd03100004f008d31ee";
		System.out.println("Requeted URL:" + url);
		System.out.println("Output: \n" + sendRequest(url, 1000 * 2));

		String url2 = "https://loggar.github.io/js/docs/sample-res/sample.1.json";
		System.out.println("Requeted URL:" + url2);
		System.out.println("Output: \n" + sendRequest(url2, 1000 * 2));
	}

	public static String sendRequest(String myURL, int timeout) {

		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(timeout);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
			in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:" + myURL, e);
		}

		return sb.toString();
	}
}
