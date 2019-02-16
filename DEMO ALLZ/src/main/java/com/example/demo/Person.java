package com.example.demo;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    public Person(String firstName) {
        this.name = firstName;
    }
    @Override
    public String toString() {
        return name;
    }
}
