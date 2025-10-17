package com.example.weather_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class WeatherServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public WeatherServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
