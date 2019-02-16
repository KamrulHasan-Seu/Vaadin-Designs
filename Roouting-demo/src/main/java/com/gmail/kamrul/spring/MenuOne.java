package com.gmail.kamrul.spring;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("menuone")
public class MenuOne extends VerticalLayout {
    public MenuOne() {
        add(new Label("Menu One"));
    }
}
