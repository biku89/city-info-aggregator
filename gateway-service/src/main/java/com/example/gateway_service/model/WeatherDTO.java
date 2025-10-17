package com.example.gateway_service.model;

import lombok.Builder;

import java.util.List;

@Builder
public record WeatherDTO(Double temperature, Double feelsLike, String condition,boolean degraded, List<ForecastHourDTO> forecastHours) {
}
