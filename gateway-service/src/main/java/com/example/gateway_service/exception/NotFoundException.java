package com.example.gateway_service.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends GatewayServiceException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
