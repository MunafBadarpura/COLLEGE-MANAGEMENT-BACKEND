package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services.implimentations;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.AdmissionRecordDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.SubjectDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.AdmissionRecord;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.Professor;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.Subject;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.exceptions.ResourceNotFoundException;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.repositories.ProfessorRepo;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.repositories.SubjectRepo;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services.SubjectService;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.utils.MapperClass;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectServiceIMPL implements SubjectService {

    private final SubjectRepo subjectRepo;
    private final ProfessorRepo professorRepo;
    private final MapperClass mapper;

    public SubjectServiceIMPL(SubjectRepo subjectRepo, ProfessorRepo professorRepo, MapperClass mapper) {
        this.subjectRepo = subjectRepo;
        this.professorRepo = professorRepo;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<ResponseModel> createSubject(SubjectDTO subjectDTO) {
        Subject subject = mapper.dtoToSubject(subjectDTO);
        Subject savedSubject = subjectRepo.save(subject);
        return Response.created(mapper.subjectToDto(savedSubject),null);
    }


    @Override
    public ResponseEntity<ResponseModel> getSubjectById(Long subjectId) {
        Optional<Subject> optionalSubject = subjectRepo.findById(subjectId);
        if (optionalSubject.isEmpty()) {
            throw new ResourceNotFoundException("Subject not found");
        }
        return Response.ok(mapper.subjectToDto(optionalSubject.get()),null);
    }

    @Override
    public ResponseEntity<ResponseModel> getAllSubject() {
        List<Subject> subjects = subjectRepo.findAll();
        List<SubjectDTO> subjectDTOS = subjects
                .stream()
                .map(subject -> mapper.subjectToDto(subject))
                .collect(Collectors.toList());

        return Response.ok(subjectDTOS, null);
    }

    @Override
    public ResponseEntity<ResponseModel> assignProfessorToSubject(Long subjectId, Long professorId) {
        Optional<Subject> optionalSubject = subjectRepo.findById(subjectId);
        Optional<Professor> optionalProfessor = professorRepo.findById(professorId);

        if (optionalSubject.isPresent() && optionalProfessor.isPresent()){
            Subject subject = optionalSubject.get();
            Professor professor = optionalProfessor.get();

            subject.setProfessor(professor);
            professor.getSubjects().add(subject);

            Professor savedProfessor = professorRepo.save(professor);
            return Response.ok(mapper.professorToDto(savedProfessor), null);
        }
        throw new ResourceNotFoundException("Professor or Subject Not Found");
    }

}
