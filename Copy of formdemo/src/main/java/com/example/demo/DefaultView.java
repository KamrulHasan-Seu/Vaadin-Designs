package com.example.demo;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class DefaultView extends VerticalLayout implements View {
    public DefaultView() {
        Label label = new Label("Defaultview");
        this.addComponent(label);
    }
}
