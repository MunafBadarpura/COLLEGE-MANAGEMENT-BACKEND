package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.AdmissionRecordDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import org.springframework.http.ResponseEntity;

public interface AdmissionRecordService {
    ResponseEntity<ResponseModel> createAdmission(AdmissionRecordDTO admissionRecordDTO);

    ResponseEntity<ResponseModel> getAdmissionById(Long admissionId);

    ResponseEntity<ResponseModel> getAllAdmission();

    ResponseEntity<ResponseModel> assignStudentToAdmissionRecord(Long admissionId, Long studentId);
}
