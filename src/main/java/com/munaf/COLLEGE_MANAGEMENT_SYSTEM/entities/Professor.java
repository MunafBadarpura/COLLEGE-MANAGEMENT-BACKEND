package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Subject> subjects;

    @ManyToMany(mappedBy = "professors")
    private List<Student> students;

}
