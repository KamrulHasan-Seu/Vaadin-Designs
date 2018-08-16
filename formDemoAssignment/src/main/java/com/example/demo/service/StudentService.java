package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.ui.UiView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
   private StudentRepository studentRepository ;

    public StudentService(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = new ArrayList<>();
        studentList = (List<Student>) studentRepository.findAll();
        return studentList;
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }
}
