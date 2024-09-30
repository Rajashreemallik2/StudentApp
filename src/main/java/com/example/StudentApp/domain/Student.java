package com.example.StudentApp.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "rollNo")
    private String rollNo;

    @Column(name = "department")
    private String Department;

    @Column(name = "city")
    private String city;

}
