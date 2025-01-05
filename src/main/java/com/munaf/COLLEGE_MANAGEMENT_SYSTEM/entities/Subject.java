package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne // foreign key
    @JoinColumn(name = "professor_id")
    private Professor professor;


    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;

}
