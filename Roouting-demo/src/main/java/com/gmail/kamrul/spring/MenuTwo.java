package com.gmail.kamrul.spring;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("menutwo")
public class MenuTwo extends VerticalLayout {
    public MenuTwo() {
        add(new Label("Menu Two"));
    }
}
