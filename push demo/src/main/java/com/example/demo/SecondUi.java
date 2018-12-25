package com.example.demo;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Push
@Route("secondui")
public class SecondUi extends VerticalLayout {
    TextField textField = new TextField();
    Button push = new Button("Push");

    private FeederThread2 feederThread;

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        add(new Span("Waiting for updates..."));

        // Start the data feed thread
        feederThread = new FeederThread2(attachEvent.getUI(),this);
        feederThread.start();
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        feederThread.interrupt();
        feederThread = null;
    }

    public SecondUi() {
        add(textField,push);
        push.addClickListener(buttonClickEvent -> {
            Notification.show("Successful");
        });
    }
}
