package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.controllers;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.SubjectDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services.SubjectService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/createSubject")
    public ResponseEntity<ResponseModel> createSubject(@RequestBody @Valid SubjectDTO subjectDTO) {
        return subjectService.createSubject(subjectDTO);
    }

    @GetMapping("/getSubjectById/{subjectId}")
    public ResponseEntity<ResponseModel> getSubjectById(@PathVariable Long subjectId) {
        return subjectService.getSubjectById(subjectId);
    }

    @GetMapping("getAllSubject")
    public ResponseEntity<ResponseModel> getAllProfessor(){
        return subjectService.getAllSubject();
    }

    @PutMapping("/{subjectId}/professor/{professorId}")
    public ResponseEntity<ResponseModel> assignProfessorToSubject(@PathVariable Long subjectId, @PathVariable Long professorId){
        return subjectService.assignProfessorToSubject(subjectId,professorId);
    }
}
