package com.example.demo;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import sun.java2d.loops.CustomComponent;

public class PlayerStatistics extends VerticalLayout {
    public PlayerStatistics() {
        this.addComponent(new Label("This is Player stats"));
    }
}
