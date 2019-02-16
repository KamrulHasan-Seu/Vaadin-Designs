package com.example.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.io.File;

@SpringUI
@Theme("valo")
@PushStateNavigation
public class MainView extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout mainLayout = new VerticalLayout();
        VerticalLayout userLayout = new VerticalLayout();

        mainLayout.setSizeFull();
        HorizontalLayout container = new HorizontalLayout();
        container.setSizeFull();


        Label title = new Label("Menu");
        title.addStyleName(ValoTheme.MENU_TITLE);
        container.addComponent(title);

        String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();
        FileResource resource = new FileResource(new File(basepath +
                "/WEB-INF/images/user.png"));
        Image image = new Image("",resource);
        image.setWidth("50px");
        image.setHeight("50px");
        userLayout.addComponent(image);
        userLayout.setSpacing(false);
        userLayout.setMargin(false);

        Button homeButton = new Button("Home", e -> getNavigator().navigateTo("Home"));
        homeButton.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);

        Button insertButton = new Button("Player Insert", e -> getNavigator().navigateTo("CricketPlayerInsert"));
        insertButton.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        insertButton.setIcon(VaadinIcons.HOME);


        Button details = new Button("Player Details", e -> getNavigator().navigateTo("playerDetails"));
        details.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button ground = new Button("Ground Insert", e -> getNavigator().navigateTo("GroundInsert"));
        ground.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button series = new Button("Series Insert", e -> getNavigator().navigateTo("SeriesInsert"));
        series.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button game = new Button("Game Insert", e -> getNavigator().navigateTo("GameInsert"));
        game.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);

        CssLayout menu = new CssLayout(title, userLayout,homeButton, insertButton, details, ground,series,game);
        menu.addStyleName(ValoTheme.MENU_ROOT);
        container.addComponent(menu);

        Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        container.addComponent(viewContainer);
        mainLayout.addComponent(container);
        mainLayout.setExpandRatio(container, 1);
        container.setExpandRatio(viewContainer, 1);
        setContent(mainLayout);
        mainLayout.setSpacing(false);
        container.setSpacing(false);
        mainLayout.setMargin(false);
        container.setMargin(false);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addView("", DefaultView.class);
        navigator.addView("Home", DefaultView.class);
        navigator.addView("CricketPlayerInsert", CricketPlayerInsert.class);
        mainLayout.setSizeFull();
    }
}
