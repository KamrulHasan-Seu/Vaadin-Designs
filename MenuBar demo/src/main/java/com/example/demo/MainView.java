package com.example.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
@Theme("valo")
@PushStateNavigation
public class MainView extends UI {

    VerticalLayout mainLayout = new VerticalLayout();
    HorizontalLayout header = new HorizontalLayout();

    Component actualComponent;
    @Override
    protected void init(VaadinRequest vaadinRequest) {


        mainLayout.addComponent(header);
        Label logo = new Label("LOGO");
        header.addComponent(logo);
        MenuBar menuBar = new MenuBar();

        MenuBar.MenuItem item = menuBar.addItem("Normal",null);
        item.addItem("Normal",e -> setMainComponent(new Form()));
        MenuBar.MenuItem stat = menuBar.addItem("statistics",e->setMainComponent(new PlayerStatistics()));
        MenuBar.MenuItem fow = menuBar.addItem("fow",null);

        header.addComponent(menuBar);
        //header.setSizeFull();
        header.setExpandRatio(menuBar,1);
        mainLayout.setSizeFull();
        menuBar.setWidth("100%");
        mainLayout.setMargin(false);
        mainLayout.setSizeFull();
        setContent(mainLayout);
    }

    private void setMainComponent(Component components) {
        if(actualComponent != null){
            mainLayout.removeComponent(actualComponent);
        }
        mainLayout.addComponent(components);
        //mainLayout.setExpandRatio(header,1);
        mainLayout.setExpandRatio(components,1);
        actualComponent = components;
    }
}
