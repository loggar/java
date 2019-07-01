package com.loggar.strings;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class EncodeDecodeUrl {
	// scheme:[//[user:password@]host[:port]][/]path[?query][#fragment]

	String testUrl = "http://www.example.com?key1=value+1&key2=value%40%21%242&key3=value%253";

	// Analyze the URL
	@Test
	public void givenURL_whenAnalyze_thenCorrect() throws Exception {
		URI uri = new URI(testUrl);

		assertThat(uri.getScheme(), is("http"));
		assertThat(uri.getHost(), is("www.example.com"));
		assertThat(uri.getRawQuery(), is("key1=value+1&key2=value%40%21%242&key3=value%253"));
	}

	private String encodeValue(String value) {
		try {
			return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	@Test
	public void givenRequestParam_whenUTF8Scheme_thenEncode() throws Exception {
		Map<String, String> requestParams = new HashMap<>();
		requestParams.put("key1", "value 1");
		requestParams.put("key2", "value@!$2");
		requestParams.put("key3", "value%3");

		String encodedURL = requestParams.keySet().stream().map(key -> key + "=" + encodeValue(requestParams.get(key))).collect(Collectors.joining("&", "http://www.example.com?", ""));

		assertThat(testUrl, is(encodedURL));
	}

	private String decode(String value) {
		try {
			return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	@Test
	public void givenRequestParam_whenUTF8Scheme_thenDecodeRequestParams() {
		URI uri;
		try {
			uri = new URI(testUrl);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			uri = null;
		}

		if (uri != null) {
			String scheme = uri.getScheme();
			String host = uri.getHost();
			String query = uri.getRawQuery();

			String decodedQuery = Arrays.stream(query.split("&")).map(param -> param.split("=")[0] + "=" + decode(param.split("=")[1])).collect(Collectors.joining("&"));

			assertEquals("http://www.example.com?key1=value 1&key2=value@!$2&key3=value%3", scheme + "://" + host + "?" + decodedQuery);
		} else {
			assert false;
		}

	}
}
