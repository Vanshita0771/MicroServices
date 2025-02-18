package com.lcwd.Hotel.Service.HotelService.exception;

import com.lcwd.Hotel.Service.HotelService.payload.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
       return new ResponseEntity<>(ErrorResponse
               .builder()
               .status(HttpStatus.NOT_FOUND)
               .message(ex.getMessage())
               .success(true)
               .build(), HttpStatus.NOT_FOUND);
    }
}
