package com.example.weather_service.clientOpenWeather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record OpenWeatherResponseDTO(
        Main main,
        List<Weather> weather
) {
    public String getDescription() {
        return (weather != null && !weather.isEmpty())
                ? weather.getFirst().description()
                : null;
    }
}

