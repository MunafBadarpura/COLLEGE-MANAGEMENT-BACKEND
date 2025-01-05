package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.repositories;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor, Long> {
}
