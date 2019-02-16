package com.example.demo;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
import java.util.List;

@Route("")
public class MainView extends VerticalLayout {
    public MainView() {
        Person jorma = new Person("Jorma");
        Person kalle = new Person("Kalle");
        List<Person> list = Arrays.asList(jorma, kalle);

        ComboBox<Person> cb = new ComboBox<>();
        cb.setItems(list);
        cb.addValueChangeListener(e -> {
            e.getSource().setValue(null);
        });

        cb.setAllowCustomValue(false);
        add(cb);
    }
}
