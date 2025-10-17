package com.example.weather_service.model;

import java.util.List;

public record WeatherDTO(Double temperature, Double feelsLike, String condition, List<ForecastHourDTO> forecastHours) {
}


