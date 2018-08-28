package com.example.demo.ui;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Position;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.aspectj.weaver.ast.Not;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringUI
@Theme("valo")
public class UiView extends UI {
    private StudentService studentService;
    private Student student = new Student();

    public UiView(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    Grid<Student> studentTableView = new Grid<Student>();
    TextField tf1;
    TextField tf2;
    TextField tf3;
    Button addButton;
    Button editButton;
    Button deleteButton;
    Button panelButton;
    Panel viewContainer;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        HorizontalLayout mainLayout = new HorizontalLayout();
        HorizontalLayout leftSide = new HorizontalLayout();
        HorizontalLayout rightSide = new HorizontalLayout();
        HorizontalLayout buttonLayout = new HorizontalLayout();

        FormLayout form = new FormLayout();
        tf1 = new TextField("ID");
        tf1.setIcon(VaadinIcons.ANCHOR);
        tf1.setRequiredIndicatorVisible(true);
        form.addComponent(tf1);
        tf2 = new TextField("NAME");
        tf2.setIcon(VaadinIcons.USER);
        form.addComponent(tf2);
        tf3 = new TextField("CGPA");
        tf3.setIcon(VaadinIcons.DIPLOMA_SCROLL);
        form.addComponent(tf3);


        addButton = new Button();
        addButton.setIcon(VaadinIcons.PLUS);
        addButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
        addButton.addClickListener(clickEvent -> {
                int id = Integer.parseInt(tf1.getValue());
                String name = tf2.getValue();
                double cgpa = Double.parseDouble(tf3.getValue());
                if (id > 0 && name != null && cgpa >= 4.0) {
                    Student student = new Student(id, name, cgpa);
                    studentService.addStudent(student);
                    studentTableView.setItems(studentService.getAllStudents());
                    Notification.show("ADDED SUCCESSFULLY").setIcon(VaadinIcons.CHECK_CIRCLE);
                }
                else{
                    Notification.show("Please Complete all the field properly").setDelayMsec(2000);
                }
        });
        form.addComponent(addButton);


        editButton = new Button();
        editButton.setIcon(VaadinIcons.PENCIL);
        editButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        editButton.addClickListener(clickEvent -> {
            Set<Student> selectedItems = studentTableView.getSelectedItems();
            for (Student s: selectedItems) {
                tf1.setValue(String.valueOf(s.getId()));
                tf2.setValue(String.valueOf(s.getName()));
                tf3.setValue(String.valueOf(s.getCgpa()));

            }
        });

        deleteButton = new Button();
        deleteButton.setIcon(VaadinIcons.TRASH);
        deleteButton.setStyleName(ValoTheme.BUTTON_DANGER);
        deleteButton.addClickListener(clickEvent -> {
            Set<Student> selectedItems = studentTableView.getSelectedItems();

            for (Student student : selectedItems) {
                studentService.deleteStudent(student);
            }
            studentTableView.setItems(studentService.getAllStudents());
           Notification.show("DELETED SUCCESSFULLY").setIcon(VaadinIcons.TRASH);
        });


        buttonLayout.addComponents(editButton, deleteButton);
        leftSide.addComponent(form);


        studentTableView.setItems(studentService.getAllStudents());
        studentTableView.addColumn(Student::getId).setCaption("ID");
        studentTableView.addColumn(Student::getName).setCaption("NAME");
        studentTableView.addColumn(Student::getCgpa).setCaption("CGPA");
        rightSide.addComponent(studentTableView);
        studentTableView.setSelectionMode(Grid.SelectionMode.MULTI);
        mainLayout.addComponents(leftSide, rightSide, buttonLayout);

        mainLayout.setWidth(null);
        mainLayout.setSizeFull();
        mainLayout.setSpacing(true);
        mainLayout.setMargin(true);
        mainLayout.setComponentAlignment(leftSide,Alignment.MIDDLE_CENTER);
        mainLayout.setComponentAlignment(rightSide,Alignment.MIDDLE_CENTER);
        mainLayout.setComponentAlignment(buttonLayout,Alignment.MIDDLE_CENTER);
        Responsive.makeResponsive(mainLayout);
        setContent(mainLayout);

    }

}
