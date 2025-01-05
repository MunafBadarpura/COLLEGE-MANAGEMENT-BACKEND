package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.advices;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.exceptions.ResourceNotFoundException;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseModel> internalServerErrorHandler(Exception exception){
        return Response.internalServerError(null, exception.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseModel> internalServerErrorHandler(ResourceNotFoundException exception){
        return Response.internalServerError(null, exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseModel> handleInputValidationError(MethodArgumentNotValidException exception){
        List<String> errors = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        return Response.internalServerError(null, errors);
    }


}
