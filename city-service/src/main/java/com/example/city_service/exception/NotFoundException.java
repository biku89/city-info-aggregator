package com.example.city_service.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends CityServiceException{

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
