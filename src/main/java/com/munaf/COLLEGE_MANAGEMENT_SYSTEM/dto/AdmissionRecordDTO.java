package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.dto;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.Student;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class AdmissionRecordDTO {
    private Long id;

    @NotNull(message = "Fees cannot be null")
    @Range(min = 1000, max = 10000000, message = "Fees can be in the range of 1000 to 10000000")
    private Integer fees;

    private StudentDTO studentDTO;

}
