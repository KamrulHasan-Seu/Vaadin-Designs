package com.example.demo;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

public class Form extends FormLayout {
    public Form() {
        TextField name = new TextField("Your Name");
        TextField age = new TextField("Your age");
        TextField email = new TextField("Your mail");

        this.addComponents(name,age,email);
    }
}
