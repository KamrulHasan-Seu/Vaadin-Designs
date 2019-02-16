package com.example.demo;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
    public MainView() {
        GridCrud<User> crud = new GridCrud<>(User.class);
    }
}
