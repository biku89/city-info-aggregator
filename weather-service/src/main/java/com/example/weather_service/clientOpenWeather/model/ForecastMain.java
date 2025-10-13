package com.example.weather_service.clientOpenWeather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ForecastMain (
        @JsonProperty("temp")
        Double temp
){
}
