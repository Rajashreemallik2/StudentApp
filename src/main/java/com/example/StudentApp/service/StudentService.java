package com.example.StudentApp.service;

import com.example.StudentApp.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    Student getStudentById(Long id);

    Student deleteStudentById(Long id);
}
