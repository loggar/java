package com.loggar.net.http;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientGetHTTPContentType {
	public static void main(String[] args) {
		HttpClientGetHTTPContentType demo = new HttpClientGetHTTPContentType();
		demo.requestPage();
		demo.requestLogo();
	}

	public void requestPage() {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet("http://google.com");
		try {
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			showContentType(entity);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void requestLogo() {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet("http://google.com/favicon.ico");
		try {
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			showContentType(entity);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showContentType(HttpEntity entity) {
		ContentType contentType = ContentType.getOrDefault(entity);
		String mimeType = contentType.getMimeType();
		Charset charset = contentType.getCharset();

		System.out.println("MimeType = " + mimeType);
		System.out.println("Charset  = " + charset);
	}
}
