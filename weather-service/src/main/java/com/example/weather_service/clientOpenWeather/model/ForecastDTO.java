package com.example.weather_service.clientOpenWeather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ForecastDTO(
        @JsonProperty("dt_txt")
        String time,
        @JsonProperty("main")
        ForecastMain main
) {
}
