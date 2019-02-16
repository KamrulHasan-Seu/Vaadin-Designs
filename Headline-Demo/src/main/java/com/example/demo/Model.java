package com.example.demo;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Model {
    private String status;
    private int totalResults;
    private List<Articles> articleList;
}
