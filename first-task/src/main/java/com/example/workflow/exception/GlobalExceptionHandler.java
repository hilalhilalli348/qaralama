package com.example.workflow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity exceptionHandler(CustomerNotFoundException customerNotFoundException){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                        customerNotFoundException.getMessage())
                    );
    }

}
