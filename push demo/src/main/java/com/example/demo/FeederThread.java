package com.example.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Span;

public  class FeederThread extends Thread {
    private final UI ui;
    private  final PushyView view ;

    public FeederThread(UI ui, PushyView view) {
        this.ui = ui;
        this.view = view;
    }
    int count = 0;



    @Override
    public void run() {
        try {
            // Update the data for a while
            while (count < 10) {
                // Sleep to emulate background work
                Thread.sleep(2000);
                String message = "This is update " + count++;
               // ui.access(() -> view.add(new Span(message)));
                ui.access(() -> view.add(new Span(message)));

            }

            // Inform that we are done
            ui.access(() -> {
                view.add(new Span("Done updating"));
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}