package com.loggar.http.connection;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientGetWithHeaders {
	public static void main(String[] args) {
		try {
			HttpClientGetWithHeaders hce = new HttpClientGetWithHeaders();
			String body = hce.get();
			System.out.println(body);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public String get() throws IOException {
		String getUrl = "https://digitalapi.auspost.com.au/postcode/search.json?q=SYDNEY&state=NSW";
		URL url = new URL(getUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("AUTH-KEY", "ade23e34-52fc-458e-8d83-67b6a2207ff7");

		return this.read(con.getInputStream());
	}

	private String read(InputStream is) throws IOException {
		BufferedReader in = null;
		String inputLine;
		StringBuilder body;
		try {
			in = new BufferedReader(new InputStreamReader(is));

			body = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				body.append(inputLine);
			}
			in.close();

			return body.toString();
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			this.closeQuietly(in);
		}
	}

	protected void closeQuietly(Closeable closeable) {
		try {
			if (closeable != null) {
				closeable.close();
			}
		} catch (IOException ex) {

		}
	}
}
