package com.example.demo;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class Mainview extends VerticalLayout {

    private UrlReader service = new UrlReaderImplementation();
    private Label label;
    private Grid<Articles> grid = new Grid<>(Articles.class);

    public Mainview() {
        this.setSizeFull();
        grid.setSizeFull();
        grid.addColumn(Articles::getTitle).setHeader("Title");
        grid.setHeight("100%");
        grid.setWidth("100%");
        grid.setItems(service.getAllNews());

        add(grid);
    }
}
