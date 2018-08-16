package com.example.demo.controller;

import com.example.demo.model.product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ControllerClass {
    @Autowired
    ProductRepository productRepository;
    @GetMapping(value = "/products")
    @ResponseBody
    public Iterable<product> getAllProducts(){
        return productRepository.findAll();
    }
}
