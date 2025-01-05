package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.utils;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.responseModel.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
    public static ResponseEntity<ResponseModel> ok(Object data, Object error){
        return new ResponseEntity<>(
                new ResponseModel(data, error),
                HttpStatus.OK
        );
    }

    public static ResponseEntity<ResponseModel> notFound(Object data, Object error){
        return new ResponseEntity<>(
                new ResponseModel(data,error),
                HttpStatus.NOT_FOUND
        );
    }

    public static ResponseEntity<ResponseModel> created(Object data, Object error){
        return new ResponseEntity<>(
                new ResponseModel(data, error),
                HttpStatus.CREATED
        );
    }

    public static ResponseEntity<ResponseModel> internalServerError(Object data, Object error){
        return new ResponseEntity<>(
                new ResponseModel(data, error),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
