package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.controllers;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.ProfessorDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/createProfessor")
    public ResponseEntity<ResponseModel> createProfessor(@RequestBody @Valid ProfessorDTO professorDTO) {
        return professorService.createProfessor(professorDTO);
    }

    @GetMapping("/getProfessorById/{professorId}")
    public ResponseEntity<ResponseModel> getProfessorById(@PathVariable Long professorId) {
        return professorService.getProfessorById(professorId);
    }

    @GetMapping("getAllProfessor")
    public ResponseEntity<ResponseModel> getAllProfessor(){
        return professorService.getAllProfessor();
    }
}
