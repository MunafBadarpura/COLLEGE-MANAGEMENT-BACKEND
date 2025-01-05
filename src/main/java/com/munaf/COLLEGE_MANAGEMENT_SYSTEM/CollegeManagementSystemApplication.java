package com.munaf.COLLEGE_MANAGEMENT_SYSTEM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollegeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeManagementSystemApplication.class, args);
	}

}


/*


public StudentDTO studentToDto(Student student) {
    StudentDTO studentDTO = new StudentDTO();
    studentDTO.setId(student.getId());
    studentDTO.setName(student.getName());

    if (student.getProfessors() != null && !student.getProfessors().isEmpty()) {
        List<ProfessorDTO> professorDTOS = student.getProfessors()
                .stream()
                .map(professor -> {
                    ProfessorDTO professorDTO = new ProfessorDTO();
                    professorDTO.setId(professor.getId());
                    professorDTO.setName(professor.getName());

                    // Check if professor has subjects
                    if (professor.getSubjects() != null && !professor.getSubjects().isEmpty()) {
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
                })
                .collect(Collectors.toList());

        studentDTO.setProfessor(professorDTOS);
    }

    return studentDTO;
}



 */
