package com.loggar.http.connection;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpClientSendRequest {
	public static void main(String[] args) {
		try {
			HttpClientSendRequest hce = new HttpClientSendRequest();
			Map<String, String> requestPropertyMap = new HashMap<>();
			String url = "https://digitalapi.auspost.com.au/postcode/search.json?q=SYDNEY&state=NSW";
			String strMethod = "GET";
			requestPropertyMap.put("AUTH-KEY", "<API-KEY-PROVIDED>");
			String res = hce.send(url, strMethod, requestPropertyMap);
			System.out.println(res);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public String send(String url, String method, Map<String, String> props) throws IOException {
		URL reqUrl = new URL(url);
		HttpURLConnection con = (HttpURLConnection) reqUrl.openConnection();
		con.setRequestMethod(method);
		if (props != null && props.size() > 0) {
			Set<String> keySet = props.keySet();
			for (String key : keySet) {
				con.setRequestProperty(key, props.get(key));
			}
		}
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
