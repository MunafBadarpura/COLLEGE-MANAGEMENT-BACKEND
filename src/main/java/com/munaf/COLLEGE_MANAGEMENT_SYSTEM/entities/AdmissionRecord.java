package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AdmissionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer fees;

    @OneToOne // foreign key
    @JoinColumn(name = "student_id")
    private Student student;
}
