package com.gmail.kamrul.spring;

import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {

        NativeButton button = new NativeButton("Iconview");
        button.addClickListener( e-> {
            button.getUI().ifPresent(ui -> ui.navigate("icons"));
        });
        NativeButton button1 = new NativeButton("TutorialView");
        button1.addClickListener( e-> {
            button1.getUI().ifPresent(ui -> ui.navigate("tutorial"));
        });
        add(button,button1);
    }
}
