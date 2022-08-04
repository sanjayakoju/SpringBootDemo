package com.ea.springbootdemo.component;

import com.ea.springbootdemo.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentManager {

    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
        students.add(new Student(1L, "Jack", 30));
        students.add(new Student(2L, "John", 20));
        students.add(new Student(3L, "Jil", 35));
        students.add(new Student(4L, "James", 29));
        students.add(new Student(5L, "Jasmin", 31));
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public Student save(Student student) {
        students.add(student);
        return student;
    }

    public Student findOne(Long id) {
        Student foundStudent = null;
        for(Student student: students) {
            if(student.getId() == id) {
                foundStudent = student;
                break;
            }
        }
        return foundStudent;
    }

    public Student deleteById(Long id) {
        Student deleteStudent = null;
        for (Student student: students) {
            if (student.getId() == id) {
                deleteStudent = student;
                break;
            }
        }
        students.remove(deleteStudent);
        return deleteStudent;
    }
}
