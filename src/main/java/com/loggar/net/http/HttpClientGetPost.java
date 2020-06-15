package com.loggar.net.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientGetPost {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) throws Exception {
        HttpClientGetPost obj = new HttpClientGetPost();
        String getUri = "http://www.mocky.io/v2/5e461c523300003800025f0e";
        String postUri = "http://www.mocky.io/v2/5e4620303300008a12025f14";

        try {
            System.out.println("Send HTTP-GET Request");
            obj.sendGet(getUri);

            System.out.println("Send HTTP-POST Request");
            obj.sendPost(postUri);
        } finally {
            obj.close();
        }
    }

    private void close() throws IOException {
        httpClient.close();
    }

    private void sendGet(String uri) throws Exception {
        HttpGet request = new HttpGet(uri);

        // add request headers
        request.addHeader("custom-key", "abcd1234");
        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            // Get HttpResponse Status
            System.out.println(
                    response.getStatusLine()
                            .toString()
            );

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        }
    }

    private void sendPost(String uri) throws Exception {
        HttpPost post = new HttpPost(uri);

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("userId", "abc"));
        urlParameters.add(new BasicNameValuePair("key", "abc123"));
        urlParameters.add(new BasicNameValuePair("count", "1001"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse response = httpClient.execute(post)) {
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }
}
