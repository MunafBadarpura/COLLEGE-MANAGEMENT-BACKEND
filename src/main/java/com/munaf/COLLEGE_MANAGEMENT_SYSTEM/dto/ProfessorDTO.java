package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class ProfessorDTO {
    private Long id;

    @NotBlank(message = "Name can not be blank")
    @Size(min = 3, max = 15, message = "Name can be in the range of 3 to 15 letters")
    private String name;

    private List<SubjectDTO> subjects;
}
