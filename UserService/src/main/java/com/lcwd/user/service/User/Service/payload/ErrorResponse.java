package com.lcwd.user.service.User.Service.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ErrorResponse {
    private String message;
    private HttpStatus status;
    private boolean success;
}
