package com.example.StudentApp.api;

import com.example.StudentApp.domain.MyClass;
import com.example.StudentApp.domain.Student;
import com.example.StudentApp.repository.StudentRepository;
import com.example.StudentApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/{name}")
    public Student getByName(@PathVariable(name = "name") String name) {
        return studentRepository.findByName(name);
    }

    @GetMapping("/by-name-city")
    public Student getStudent(@RequestParam(name = "name") String name, @RequestParam(name = "city") String city) {
        return studentRepository.findByNameAndCity(name, city);
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody MyClass var1) {
        Student student = new Student();
        student.setName(var1.getName());
        student.setCity(var1.getCity());
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable(name = "id") Long id, @RequestBody MyClass var2) {

        Student student = studentRepository.findById(id).get();

        if (student != null) {
            if (var2 != null) {
                if (var2.getRollNo() != null) {
                    student.setRollNo(var2.getRollNo());
                }

                if (var2.getDepartment() != null) {
                    student.setDepartment(var2.getDepartment());
                }

                if (var2.getName() != null) {
                    student.setName(var2.getName());
                }

                if (var2.getCity() != null) {
                    student.setCity(var2.getCity());
                }

                return studentRepository.save(student);
            }
        }

        return null;
    }
}

