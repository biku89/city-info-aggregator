package com.example.info_service.exception;

import org.springframework.http.HttpStatus;

public class IncorrectCoordinatesException extends InfoServiceException {
    public IncorrectCoordinatesException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
