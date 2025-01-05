package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.utils;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.AdmissionRecordDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.ProfessorDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.StudentDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto.SubjectDTO;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.AdmissionRecord;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.Professor;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.Student;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.Subject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperClass {

    // Conversion Methods
    public Student dtoToStudent(StudentDTO studentDTO){ //we dont have id here
        Student student = new Student();
        student.setName(studentDTO.getName());
        return student;
    }

    public StudentDTO studentToDto(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());

        if (student.getProfessors() != null){
            List<ProfessorDTO> professorDTOS = student.getProfessors()
                    .stream()
                    .map(professor -> {
                        ProfessorDTO professorDTO = new ProfessorDTO();
                        professorDTO.setId(professor.getId());
                        professorDTO.setName(professor.getName());
                        return professorDTO;
                    })
                    .collect(Collectors.toList());
            studentDTO.setProfessor(professorDTOS);
        }

        if (student.getSubjects() != null){
            List<SubjectDTO> subjectDTOS = student.getSubjects()
                    .stream()
                    .map(subject -> {
                        SubjectDTO subjectDTO = new SubjectDTO();
                        subjectDTO.setId(subject.getId());
                        subjectDTO.setTitle(subject.getTitle());
                        return subjectDTO;
                    })
                    .collect(Collectors.toList());
            studentDTO.setSubjects(subjectDTOS);
        }

        return studentDTO;
    }

    public AdmissionRecord dtoToAdmissionRecord(AdmissionRecordDTO admissionRecordDTO) {
        AdmissionRecord admissionRecord = new AdmissionRecord();
        admissionRecord.setFees(admissionRecordDTO.getFees());
        return admissionRecord;
    }


    public AdmissionRecordDTO admissionRecordToDto(AdmissionRecord admissionRecord) {
        AdmissionRecordDTO admissionRecordDTO = new AdmissionRecordDTO();
        admissionRecordDTO.setId(admissionRecord.getId());
        admissionRecordDTO.setFees(admissionRecord.getFees());

        if (admissionRecord.getStudent() != null){
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(admissionRecord.getStudent().getId());
            studentDTO.setName(admissionRecord.getStudent().getName());
            admissionRecordDTO.setStudentDTO(studentDTO);
        }
        return admissionRecordDTO;
    }


    public Professor dtoToProfessor(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setName(professorDTO.getName());
        return professor;
    }


    public ProfessorDTO professorToDto(Professor professor) {
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setId(professor.getId());
        professorDTO.setName(professor.getName());

        if (professor.getSubjects() != null){
            List<SubjectDTO> subjectDTOS = professor.getSubjects()
                    .stream()
                    .map(subject -> {
                        SubjectDTO subjectDTO = new SubjectDTO();
                        subjectDTO.setId(subject.getId());
                        subjectDTO.setTitle(subject.getTitle());
                        return subjectDTO;
                    })
                    .collect(Collectors.toList());

            professorDTO.setSubjects(subjectDTOS);
        }

        return professorDTO;
    }

    public Subject dtoToSubject(SubjectDTO subjectDTO){
        Subject subject = new Subject();
        subject.setTitle(subjectDTO.getTitle());
        return subject;
    }

    public SubjectDTO subjectToDto(Subject subject){
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(subject.getId());
        subjectDTO.setTitle(subject.getTitle());
        return subjectDTO;
    }
}
