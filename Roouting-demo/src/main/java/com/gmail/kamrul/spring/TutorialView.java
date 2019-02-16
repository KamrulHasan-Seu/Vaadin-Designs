package com.gmail.kamrul.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "tutorial", layout = MenuBar.class)
public class TutorialView extends Div {
    public TutorialView() {
        FormLayout form = new FormLayout();
        add(form);

        Label label = new Label("TutorialView");
        TextField name = new TextField("Name");
        PasswordField pass = new PasswordField("Password");
        Button button = new Button("Save");

        form.add(label,name,pass,button);

        button.addClickListener(e -> {
//            Dialog dialog = new Dialog();
//            Label caption = new Label("Are You Sure?");
////            HorizontalLayout horizontalLayout = new HorizontalLayout();
////            Button yes = new Button("save");
////            Button no = new Button("no");
////            horizontalLayout.add(yes,no);
//
//            dialog.add(caption);
//            dialog.setWidth("400px");
//            dialog.setHeight("400px");
//            add(dialog);
            button.getUI().ifPresent(ui-> ui.navigate("icons"));
        });
    }
}