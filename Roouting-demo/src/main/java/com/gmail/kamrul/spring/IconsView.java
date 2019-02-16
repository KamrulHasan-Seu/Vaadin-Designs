package com.gmail.kamrul.spring;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value="icons", layout = MenuBar.class)
public class IconsView extends Div {

    ConfirmDialog dialog;
    public IconsView() {
        FormLayout form = new FormLayout();
        add(form);

        Label label = new Label("IconsView");
        TextField name = new TextField("Name");
        PasswordField pass = new PasswordField("Password");
        Button button = new Button("Save");



        button.addClickListener(buttonClickEvent ->{
             dialog = new ConfirmDialog("Unsaved changes",
                    "Do you want to save or discard your changes before navigating away?",
                    "Cancel",
                    this::onCancel);
        });

        form.add(label,name,pass,button);
    }

    private void onCancel(ConfirmDialog.ConfirmEvent confirmEvent) {
        dialog.close();


    }


}
