package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.repositories;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.StudentDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
