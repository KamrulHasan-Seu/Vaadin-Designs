package com.example.demo;


import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

public class  FeederThread extends Thread{
    private final UI ui;
    private final PushyView pushyView;

    public FeederThread(UI ui, PushyView pushyView) {
        this.ui = ui;
        this.pushyView = pushyView;
    }

    int count = 5;

    @Override
    public void run() {
        while (count<5){
           ui.access(()->
           Notification.show("Success"));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }
}


