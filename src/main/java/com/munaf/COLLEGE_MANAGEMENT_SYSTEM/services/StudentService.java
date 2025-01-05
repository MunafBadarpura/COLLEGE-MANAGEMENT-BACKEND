package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.StudentDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<ResponseModel> createStudent(StudentDTO studentDTO);

    ResponseEntity<ResponseModel> getStudentById(Long studentId);

    ResponseEntity<ResponseModel> getAllStudent();

    ResponseEntity<ResponseModel> assignProfessorToStudent(Long studentId, Long professorId);

    ResponseEntity<ResponseModel> assignSubjectToStudent(Long studentId, Long subjectId);
}
