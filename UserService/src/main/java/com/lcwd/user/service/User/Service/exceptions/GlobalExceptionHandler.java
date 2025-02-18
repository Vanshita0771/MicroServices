package com.lcwd.user.service.User.Service.exceptions;

import com.lcwd.user.service.User.Service.payload.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND).
                body(ErrorResponse
                        .builder()
                        .message(ex.getMessage())
                        .status(HttpStatus.NOT_FOUND)
                        .success(true)
                        .build());
    }

}
