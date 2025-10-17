package com.example.city_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CityServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public CityServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
