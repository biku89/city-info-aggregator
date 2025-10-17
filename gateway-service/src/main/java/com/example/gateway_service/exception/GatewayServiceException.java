package com.example.gateway_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GatewayServiceException extends RuntimeException {
    private final HttpStatus httpStatus;
    public GatewayServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
