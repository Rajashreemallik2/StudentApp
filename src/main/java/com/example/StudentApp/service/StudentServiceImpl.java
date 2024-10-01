package com.example.StudentApp.service;

import com.example.StudentApp.domain.Student;
import com.example.StudentApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student studentRequest) {
        if (studentRequest != null) {
            Student student1 = studentRepository.findById(studentRequest.getId()).get();

            if (studentRequest.getName() != null) {
                student1.setName(studentRequest.getName());
            }

            if (studentRequest.getCity() != null) {
                student1.setCity(studentRequest.getCity());
            }

            if (studentRequest.getRollNo()!=null){
                student1.setRollNo(studentRequest.getRollNo());
            }

            if (studentRequest.getDepartment()!=null){
                student1.setDepartment(studentRequest.getDepartment());
            }

            return studentRepository.save(student1);
        }
        return null;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student deleteStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            studentRepository.deleteById(id);
        }
        return student;
    }
}
