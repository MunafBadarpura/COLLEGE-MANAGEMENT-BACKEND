package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.controllers;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.StudentDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.repositories.StudentRepo;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/createStudent")
    public ResponseEntity<ResponseModel> createStudent(@RequestBody @Valid StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }

    @GetMapping("getStudentById/{studentId}")
    public ResponseEntity<ResponseModel> getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping("getAllStudent")
    public ResponseEntity<ResponseModel> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PutMapping("{studentId}/professor/{professorId}")
    public ResponseEntity<ResponseModel> assignProfessorToStudent(@PathVariable Long studentId, @PathVariable Long professorId){
        return studentService.assignProfessorToStudent(studentId,professorId);
    }

    @PutMapping("{studentId}/subject/{subjectId}")
    public ResponseEntity<ResponseModel> assignSubjectToStudent(@PathVariable Long studentId, @PathVariable Long subjectId){
        return studentService.assignSubjectToStudent(studentId,subjectId);
    }
}
