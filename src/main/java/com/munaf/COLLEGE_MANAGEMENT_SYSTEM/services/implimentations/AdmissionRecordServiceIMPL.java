package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services.implimentations;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.AdmissionRecordDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.StudentDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.AdmissionRecord;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.Student;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.exceptions.ResourceNotFoundException;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.repositories.AdmissionRecordRepo;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.repositories.StudentRepo;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services.AdmissionRecordService;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.utils.MapperClass;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdmissionRecordServiceIMPL implements AdmissionRecordService {

    private final AdmissionRecordRepo admissionRecordRepo;
    private final StudentRepo studentRepo;
    private final MapperClass mapper;

    public AdmissionRecordServiceIMPL(AdmissionRecordRepo admissionRecordRepo, StudentRepo studentRepo, MapperClass mapper) {
        this.admissionRecordRepo = admissionRecordRepo;
        this.studentRepo = studentRepo;
        this.mapper = mapper;
    }

    public ResponseEntity<ResponseModel> createAdmission(AdmissionRecordDTO admissionRecordDTO) {
        AdmissionRecord admissionRecord = mapper.dtoToAdmissionRecord(admissionRecordDTO);
        AdmissionRecord savedAdmissionRecord = admissionRecordRepo.save(admissionRecord);
        return Response.created(mapper.admissionRecordToDto(savedAdmissionRecord), null);
    }

    public ResponseEntity<ResponseModel> getAdmissionById(Long admissionId) {
        Optional<AdmissionRecord> optionalAdmissionRecord = admissionRecordRepo.findById(admissionId);
        if (optionalAdmissionRecord.isEmpty()) {
            throw new ResourceNotFoundException("Admission record not found");
        }

        return Response.ok(mapper.admissionRecordToDto(optionalAdmissionRecord.get()), null);
    }

    @Override
    public ResponseEntity<ResponseModel> getAllAdmission() {
        List<AdmissionRecord> admissionRecords = admissionRecordRepo.findAll();
        List<AdmissionRecordDTO> admissionRecordDTOS = admissionRecords
                .stream()
                .map(admissionRecord -> mapper.admissionRecordToDto(admissionRecord))
                .collect(Collectors.toList());

        return Response.ok(admissionRecordDTOS, null);
    }

    @Override
    public ResponseEntity<ResponseModel> assignStudentToAdmissionRecord(Long admissionId, Long studentId) {
        Optional<AdmissionRecord> optionalAdmissionRecord = admissionRecordRepo.findById(admissionId);
        Optional<Student> optionalStudent = studentRepo.findById(studentId);

        if (optionalAdmissionRecord.isPresent() && optionalStudent.isPresent()) {
            AdmissionRecord admissionRecord = optionalAdmissionRecord.get();
            Student student = optionalStudent.get();

            admissionRecord.setStudent(student); // assign student to admission record
            AdmissionRecord savedAdmissionRecord = admissionRecordRepo.save(admissionRecord); // saved this new record

            return Response.ok(mapper.admissionRecordToDto(savedAdmissionRecord),null);
        }
        throw new ResourceNotFoundException("Admission or Student Not Found");
    }

}
