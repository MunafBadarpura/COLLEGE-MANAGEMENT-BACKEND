package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services.implimentations;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.StudentDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.Professor;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.Student;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.Subject;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.exceptions.ResourceNotFoundException;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.repositories.ProfessorRepo;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.repositories.StudentRepo;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.repositories.SubjectRepo;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.services.StudentService;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.utils.MapperClass;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceIMPL implements StudentService {

    private final StudentRepo studentRepo;
    private final ProfessorRepo professorRepo;
    private final SubjectRepo subjectRepo;
    private final MapperClass mapper;

    public StudentServiceIMPL(StudentRepo studentRepo, ProfessorRepo professorRepo, SubjectRepo subjectRepo, MapperClass mapper) {
        this.studentRepo = studentRepo;
        this.professorRepo = professorRepo;
        this.subjectRepo = subjectRepo;
        this.mapper = mapper;
    }

    public ResponseEntity<ResponseModel> createStudent(StudentDTO studentDTO){
        Student student = mapper.dtoToStudent(studentDTO);
        Student savedStudent = studentRepo.save(student);
        return Response.created(mapper.studentToDto(savedStudent), null);
    }


    public ResponseEntity<ResponseModel> getStudentById(Long studentId) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        if (optionalStudent.isEmpty()) {
            throw new ResourceNotFoundException("Student Not Found");
        }

        return Response.ok(mapper.studentToDto(optionalStudent.get()), null);
    }

    @Override
    public ResponseEntity<ResponseModel> getAllStudent() {
        List<Student> students = studentRepo.findAll();
        List<StudentDTO> studentDTOS = students
                .stream()
                .map(student -> mapper.studentToDto(student))
                .collect(Collectors.toList());

        return Response.ok(studentDTOS, null);
    }

    @Override
    public ResponseEntity<ResponseModel> assignProfessorToStudent(Long studentId, Long professorId) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        Optional<Professor> optionalProfessor = professorRepo.findById(professorId);

        if (optionalStudent.isPresent() && optionalProfessor.isPresent()){
            Student student = optionalStudent.get();
            Professor professor = optionalProfessor.get();

            student.getProfessors().add(professor);
            professor.getStudents().add(student);

            Student savedStudent = studentRepo.save(student);
            return Response.ok(mapper.studentToDto(savedStudent),null);

        }

        throw new ResourceNotFoundException("Student or Professor Not Found");
    }

    @Override
    public ResponseEntity<ResponseModel> assignSubjectToStudent(Long studentId, Long subjectId) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        Optional<Subject> optionalSubject = subjectRepo.findById(subjectId);

        if (optionalStudent.isPresent() && optionalSubject.isPresent()){
            Student student = optionalStudent.get();
            Subject subject = optionalSubject.get();

            student.getSubjects().add(subject);
            subject.getStudents().add(student);

            Student savedStudent = studentRepo.save(student);
            return Response.ok(mapper.studentToDto(savedStudent),null);

        }
        throw new ResourceNotFoundException("Student or Subject Not Found");
    }

}
