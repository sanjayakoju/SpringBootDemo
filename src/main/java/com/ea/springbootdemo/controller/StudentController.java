package com.ea.springbootdemo.controller;

import com.ea.springbootdemo.component.StudentManager;
import com.ea.springbootdemo.model.Student;
import com.ea.springbootdemo.util.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentManager studentManager;

    @PostMapping(path = "/students")
    public Student saveStudent(@RequestBody Student student) {
        Student saveStudent = studentManager.save(student);
        return saveStudent;
    }

    @DeleteMapping(path = "students/{student_id}")
    public Student deleteStudent(@PathVariable("student_id") Long id) {
        Student student = studentManager.findOne(id);
        if (student == null) {
            throw new UserNotFoundException("User with id : "+id+ " not found !!!");
        }
        studentManager.deleteById(id);
        return student;
    }

    @GetMapping(path = "/students/{student_id}")
    public Student getStudent(@PathVariable("student_id") Long id) {
        Student student = studentManager.findOne(id);
        if (student == null) {
            throw new UserNotFoundException("User with id : "+id+ " not found !!!");
        }
        return student;
    }

    @GetMapping(path = "/students")
    public List<Student> getAllStudents() {
        return  studentManager.getStudents();
    }


}
