package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Articles {
    private Source source;
    private String author;
    private String title;
    private String description;
    private URL url;
    private URL urlToImage;
    private String publishedAt;
    private String content;
}
