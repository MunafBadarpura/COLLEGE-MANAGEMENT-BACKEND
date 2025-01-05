package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SubjectDTO {
    private Long id;

    @NotBlank(message = "Title can not be blank")
    @Size(min = 3, max = 15, message = "Title can be in the range of 3 to 15 letters")
    private String title;
}
