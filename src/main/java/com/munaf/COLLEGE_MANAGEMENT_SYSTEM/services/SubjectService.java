package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.SubjectDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import org.springframework.http.ResponseEntity;

public interface SubjectService {
    ResponseEntity<ResponseModel> getSubjectById(Long subjectId);

    ResponseEntity<ResponseModel> createSubject(SubjectDTO subjectDTO);

    ResponseEntity<ResponseModel> getAllSubject();

    ResponseEntity<ResponseModel> assignProfessorToSubject(Long subjectId, Long professorId);
}
