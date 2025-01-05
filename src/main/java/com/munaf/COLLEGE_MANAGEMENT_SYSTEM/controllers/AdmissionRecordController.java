package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.controllers;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.AdmissionRecordDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services.AdmissionRecordService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admission")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @PostMapping("/createAdmission")
    public ResponseEntity<ResponseModel> createAdmission(@RequestBody @Valid AdmissionRecordDTO admissionRecordDTO) {
        return admissionRecordService.createAdmission(admissionRecordDTO);
    }

    @GetMapping("/getAdmissionById/{admissionId}")
    public ResponseEntity<ResponseModel> getAdmissionById(@PathVariable Long admissionId) {
        return admissionRecordService.getAdmissionById(admissionId);
    }

    @GetMapping("getAllAdmission")
    public ResponseEntity<ResponseModel> getAllAdmission(){
        return admissionRecordService.getAllAdmission();
    }

    @PutMapping("{admissionId}/student/{studentId}")
    public ResponseEntity<ResponseModel> assignStudentToAdmissionRecord(@PathVariable Long admissionId, @PathVariable Long studentId){
        return admissionRecordService.assignStudentToAdmissionRecord(admissionId, studentId);
    }

}
