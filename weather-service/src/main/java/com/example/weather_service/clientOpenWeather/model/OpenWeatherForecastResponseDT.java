package com.example.weather_service.clientOpenWeather.model;

import java.util.List;

public record OpenWeatherForecastResponseDT(
        List<ForecastDTO> list
) {
}
