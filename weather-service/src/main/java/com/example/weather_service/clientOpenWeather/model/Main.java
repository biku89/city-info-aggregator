package com.example.weather_service.clientOpenWeather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Main(
        @JsonProperty("temp")
        Double temperature,
        @JsonProperty("feels_like")
        Double feelsLike
) {
}
