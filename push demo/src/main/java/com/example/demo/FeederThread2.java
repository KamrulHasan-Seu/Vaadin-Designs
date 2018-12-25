package com.example.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;

public  class FeederThread2 extends Thread {
    private final UI ui;
    private  SecondUi sU ;

    public FeederThread2(UI ui, SecondUi sU) {
        this.ui = ui;
        this.sU = sU;
    }

    int count = 0;



    @Override
    public void run() {
        // Update the data for a while
//            while (count < 10) {
//                // Sleep to emulate background work
//                Thread.sleep(2000);
//                String message = "Successfull " + count++;
//
//                ui.access(() -> sU.add(new Span(message)));
//
//            }
        while(count<10){
            ui.access(()-> Notification.show("Successfull"));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }

        // Inform that we are done
        ui.access(() -> {
            sU.add(new Span("Done updating"));
        });
    }

}