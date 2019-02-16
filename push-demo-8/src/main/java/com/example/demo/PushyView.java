package com.example.demo;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

@Push
@SpringUI
@Theme("valo")
public class PushyView extends UI {

    private  StudentService studentService;
    private FeederThread thread ;

    public PushyView(StudentService studentService) {
        this.studentService = studentService;
    }
    Grid<student> grid = new Grid<>();

    @Override
    public void attach(AttachEvent attachEvent) {
        thread = new FeederThread(,this);
        thread.start();
    }
    @Override
    protected void onAttach(AttachEvent attachEvent) {
        addCom(new Span("Waiting for updates"));

        // Start the data feed thread
        thread = new FeederThread(attachEvent.getUI(), this);
        thread.start();
    }
    @Override
    public void detach() {
        thread.interrupt();
        thread = null;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout verticalLayout = new VerticalLayout();


        grid.setSizeFull();
        verticalLayout.addComponent(grid);


        grid.setItems(studentService.getAllStudents());
        grid.addColumn(student::getId).setCaption("ID");
        grid.addColumn(student::getName).setCaption("NAME");
        grid.addColumn(student::getCgpa).setCaption("CGPA");

        setContent(verticalLayout);



    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = PushyView.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
//
//    class  FeederThread extends Thread{
//        int count = 5;
//
//        @Override
//        public void run() {
//           while (count<5){
//               Notification.show("Success");
//               UI.getCurrent().push();
////               grid.setItems(studentService.getAllStudents());
////               getUI().push();
////               try {
////                   Thread.sleep(5000);
////               } catch (InterruptedException e) {
////                   e.printStackTrace();
////               }
//               try {
//                   Thread.sleep(2000);
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//               count++;
//           }
//        }
//    }
//
