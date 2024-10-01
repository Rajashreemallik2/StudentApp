package com.example.StudentApp.repository;

import com.example.StudentApp.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByName(String name);

    Student findByNameAndCity(String name, String city);
}
