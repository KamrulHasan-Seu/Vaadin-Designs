package com.example.demo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class UrlReaderImplementation implements UrlReader{

    @Override
    public List<Articles> getAllNews() {

        RestTemplate restTemplate = new RestTemplate();
        Model forObject = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?sources=espn-cric-info&apiKey=434e3d43dc0249caa06b812a44739aaa", Model.class);
        return forObject.getArticleList();
    }
}
