package com.example.weather_service.service;

import com.example.weather_service.exception.IncorrectCoordinatesException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WeatherValidator {
    public static void incorrectLat(double lat) {
        if (lat < -90 || lat > 90) {
            throw new IncorrectCoordinatesException("Latitude value must be between min -90 and max 90");
        }
    }

    public static void incorrectLon(double lon) {
        if (lon < -180 || lon > 180) {
            throw new IncorrectCoordinatesException("Longitude value must be between min -180 and max 180");

        }
    }
}
