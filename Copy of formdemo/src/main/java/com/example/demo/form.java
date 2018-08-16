package com.example.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@SpringUI
@Theme("valo")
public class form extends UI {

    private VerticalLayout fullLayout = new VerticalLayout();

    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addForm();
        addToDoList();
        addActionButton();
    }

    private void setupLayout() {
        fullLayout = new VerticalLayout();
        fullLayout.setWidth("80%");
        fullLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(fullLayout);
    }

    private void addToDoList() {


    }

    private void addHeader() {
        Label label = new Label("Form");
        label.setStyleName(ValoTheme.LABEL_H1);
        fullLayout.addComponent(label);
    }

    private void addForm() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setWidth("80%");

        TextField textField = new TextField();
        textField.setWidth("100%");
        Button button = new Button("");
        button.setIcon(VaadinIcons.PLUS);
        button.setStyleName(ValoTheme.BUTTON_PRIMARY);
        horizontalLayout.addComponent(textField);
        horizontalLayout.addComponent(button);
        fullLayout.addComponent(horizontalLayout);
    }


    private void addActionButton() {
        Button deleteButton = new Button();

        deleteButton.setIcon(VaadinIcons.ARROWS_CROSS);
        deleteButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

        fullLayout.addComponent(deleteButton);
    }
}
