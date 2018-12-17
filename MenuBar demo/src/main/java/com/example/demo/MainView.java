package com.example.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
@Theme("valo")
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
       // fow.addItem("stats",new MenuCommand(PlayerStatistics.class));

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

//    private class MenuCommand implements MenuBar.Command {
//        private Class myClass;
//        private Component comp;
//        public MenuCommand(Class compacClass) {
//            myClass = compacClass;
//        }
//
//        @Override
//        public void menuSelected(MenuBar.MenuItem menuItem) {
//           if(comp == null)
//               try {
//                   comp = (Component) myClass.newInstance();
//               } catch (InstantiationException e) {
//                   e.printStackTrace();
//               } catch (IllegalAccessException e) {
//                   e.printStackTrace();
//               }
//               setMainComponent(comp);
//
//        }
//    }
}
