
package com.example.demo.client;

import com.example.demo.dto.GoogleBookResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GoogleBookClient {

    @Value("${google.books.base-url}")
    private String baseUrl;

    @Value("${google.books.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public GoogleBookResponse searchBooks(String query){

        String url = baseUrl + "/volumes?q=" + query + "&key=" + apiKey;

        return restTemplate.getForObject(url, GoogleBookResponse.class);
    }
}
