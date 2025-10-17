package com.example.weather_service.exception;

import org.springframework.http.HttpStatus;

public class IncorrectCoordinatesException extends WeatherServiceException {
    public IncorrectCoordinatesException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
