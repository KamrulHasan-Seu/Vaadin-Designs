package com.example.demo;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

public class FormInput extends FormLayout {
    public FormInput() {

        TextField name = new TextField("Name");
        TextField age = new TextField("Age");
        Button button = new Button("save");

        this.addComponents(name,age,button);
    }
}
