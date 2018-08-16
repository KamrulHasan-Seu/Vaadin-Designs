package com.example.demo;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

@SpringUI
public class Form extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        TextField textField= new TextField();
        Label label1 = new Label("Name :");
        label1.setIcon(VaadinIcons.USER);
        horizontalLayout.addComponent(label1);
        horizontalLayout.addComponent(textField);
       // horizontalLayout.setComponentAlignment(textField,Alignment.TOP_CENTER);

        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        TextField textField2 = new TextField();
        Label label2 = new Label("Street Address :");
        horizontalLayout2.addComponent(label2);
        horizontalLayout2.addComponent(textField2);
       //horizontalLayout.setComponentAlignment(textField2,Alignment.TOP_CENTER);

        verticalLayout.addComponent(horizontalLayout);
        verticalLayout.addComponent(horizontalLayout2);
        setContent(verticalLayout);

    }
}
