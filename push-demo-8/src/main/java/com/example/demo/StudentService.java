package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private  StudentRepo studentRepo;

    public List<student> getAllStudents(){
        List<student> studentList = new ArrayList<>();
        studentList = (List<student>) studentRepo.findAll();
        return studentList;
    }

    public void addStudent(student model){
        studentRepo.save(model);
    }
    public void deleteStudent(student model){
        studentRepo.delete(model);
    }
}
