package com.sunfintech.base.net.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * 使用jdk11原生http进行实现
 *
 *
 * @author yangcj
 */
public class HttpClientUtils {


    public static void main(String[] args) throws IOException, InterruptedException {
        post();

    }


    /**
     *
     * @throws IOException
     * @throws InterruptedException
     */
    private static void post() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString("{json:json}")).build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
    }


    /**
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public static void get() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();


        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://www.baidu.com"))
                .GET().build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String body = httpResponse.body();
        System.out.println(body);
    }


}
