package com.example.demo.Ui;

import com.example.demo.model.Student;
import com.vaadin.annotations.Theme;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SpringUI

public class HelloUI extends UI {
    private List<Student> studentList;

    public HelloUI() {
        // HW: instead of working with fake data, make sure that
        // the data is read from a web service
        studentList = new ArrayList<>();
        studentList.add(new Student(10, "Abul", 2.99));
        studentList.add(new Student(20, "Babul", 2.70));
        studentList.add(new Student(21, "Kabul", 3.21));
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Label label = new Label("Hello World");
        Button button  = new Button("Suck");
        button.addClickListener(clickEvent ->
        Notification.show("HelloDear"));
        label.setValue("Shamim Voxod");

        Grid<Student> grid = new Grid<>();
        grid.setItems(studentList);
        grid.addColumn(Student::getId).setCaption("Student Id");
        grid.addColumn(Student::getName).setCaption("Student Name");
        grid.addColumn(Student::getCgpa).setCaption("Cgpa");

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(label);
        horizontalLayout.addComponent(button);

        TextField textField = new TextField();
        textField.setValue("Enter Something");
        horizontalLayout.addComponent(textField);
        horizontalLayout.setComponentAlignment(textField,Alignment.BOTTOM_LEFT);
        TextArea text = new TextArea();
        text.setValue(" I am the example of Text Area in Vaadin");
        horizontalLayout.addComponent(text);
        horizontalLayout.setComponentAlignment(text,Alignment.TOP_RIGHT);
        Label l1 = new Label("Enter today's Date\n",ContentMode.PREFORMATTED);
        DateField date = new DateField();
        date.setValue(LocalDate.now());
       date.setLocale(new Locale("en","IND"));
        horizontalLayout.addComponents(l1,date);
        horizontalLayout.setComponentAlignment(l1,Alignment.BOTTOM_CENTER);
        horizontalLayout.setComponentAlignment(date,Alignment.BOTTOM_CENTER);
        VerticalLayout verticalLayout = new VerticalLayout();
      verticalLayout.addComponent(grid);


        Link link = new Link("Click Me",new ExternalResource("https://www.tutorialspoint.com/"));
        verticalLayout.addComponent(link);
        verticalLayout.addComponent(horizontalLayout);
        setContent(verticalLayout);
    }
}
