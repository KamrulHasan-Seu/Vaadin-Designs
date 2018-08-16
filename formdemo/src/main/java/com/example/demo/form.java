package com.example.demo;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
@SpringUI
public class form extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        FormLayout form = new FormLayout();
        TextField tf1 = new TextField("Name");
        tf1.setIcon(VaadinIcons.USER);
        tf1.setRequiredIndicatorVisible(true);
        form.addComponent(tf1);
        TextField tf2 = new TextField("Street address");
        tf2.setIcon(VaadinIcons.ROAD);
        form.addComponent(tf2);
        TextField tf3 = new TextField("Postal code");
        tf3.setIcon(VaadinIcons.ENVELOPE);
        form.addComponent(tf3);

        // normally comes from validation by Binder
        tf3.setComponentError(new UserError("Doh!"));
        setContent(form);
    }
}
