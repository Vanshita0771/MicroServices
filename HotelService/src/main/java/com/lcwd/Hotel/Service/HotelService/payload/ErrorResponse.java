package com.lcwd.Hotel.Service.HotelService.payload;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ErrorResponse {
    private String message;
    private HttpStatus status;
    private boolean success;
}
