package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services.implimentations;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.ProfessorDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.Professor;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.exceptions.ResourceNotFoundException;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.repositories.ProfessorRepo;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services.ProfessorService;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.utils.MapperClass;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceIMPL implements ProfessorService {

    private final ProfessorRepo professorRepo;
    private final MapperClass mapper;

    public ProfessorServiceIMPL(ProfessorRepo professorRepo, MapperClass mapper) {
        this.professorRepo = professorRepo;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<ResponseModel> createProfessor(ProfessorDTO professorDTO) {
        Professor professor = mapper.dtoToProfessor(professorDTO);
        Professor savedProfessor = professorRepo.save(professor);
        return Response.created(mapper.professorToDto(savedProfessor), null);
    }

    @Override
    public ResponseEntity<ResponseModel> getProfessorById(Long professorId) {
        Optional<Professor> optionalProfessor = professorRepo.findById(professorId);
        if (optionalProfessor.isEmpty()) {
            throw new ResourceNotFoundException("Professor not found");
        }
        return Response.ok(mapper.professorToDto(optionalProfessor.get()), null);
    }

    @Override
    public ResponseEntity<ResponseModel> getAllProfessor() {
        List<Professor> professors = professorRepo.findAll();
        List<ProfessorDTO> professorDTOS = professors
                .stream()
                .map(professor -> mapper.professorToDto(professor))
                .collect(Collectors.toList());

        return Response.ok(professors, null);
    }
}
