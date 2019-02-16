package com.example.demo;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class CricketPlayerInsert extends VerticalLayout implements View {
    public CricketPlayerInsert() {
        Label label = new Label("CricketPlayerInsert");
        this.addComponent(label);
    }
}
