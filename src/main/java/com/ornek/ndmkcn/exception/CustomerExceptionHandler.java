package com.ornek.ndmkcn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomerExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> customerNotFoundException(CustomerNotFoundException customerNotFoundException) {
        List<String> detail=new ArrayList<>();
        detail.add(customerNotFoundException.getMessage());
        ErrorResponse errorResponse=new ErrorResponse("Customer Not Found!",detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CustomerNotNullException.class)
    public ResponseEntity<?> customerNotNullException(CustomerNotNullException customerNotNullException) {
        List<String> detail=new ArrayList<>();
        detail.add(customerNotNullException.getMessage());
        ErrorResponse errorResponse=new ErrorResponse("Customer Not Null!",detail);
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
