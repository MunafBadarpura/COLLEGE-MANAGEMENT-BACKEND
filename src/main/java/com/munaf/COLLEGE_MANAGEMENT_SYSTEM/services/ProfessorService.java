package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.ProfessorDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import org.springframework.http.ResponseEntity;

public interface ProfessorService {
    ResponseEntity<ResponseModel> createProfessor(ProfessorDTO professorDTO);

    ResponseEntity<ResponseModel> getProfessorById(Long professorId);

    ResponseEntity<ResponseModel> getAllProfessor();
}
