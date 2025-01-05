package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.StudentDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "student")
    private AdmissionRecord admissionRecord;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_professor_table",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private List<Professor> professors;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_subject_table",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;

}
