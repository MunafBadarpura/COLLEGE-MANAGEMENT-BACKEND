package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
public class ResponseModel {
    @JsonFormat(pattern = "hh:mm:ss dd/MM/yyyy")
    private LocalDateTime timestamp;
    private Object data;
    private Object error;

    public ResponseModel(Object data, Object error) {
        this.timestamp = LocalDateTime.now();
        this.data = data;
        this.error = error;
    }
}
