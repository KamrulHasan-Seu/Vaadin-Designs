package com.gmail.kamrul.spring;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

//@ParentLayout(MainView.class)
public class MenuBar extends Div implements RouterLayout  {
    public MenuBar() {
        addMenuElement(TutorialView.class, "Tutorial");
        addMenuElement(IconsView.class, "Icons");
    }
    private void addMenuElement(Class<? extends Component> navigationTarget,
                                String name) {
        // implementation omitted
    }
}
