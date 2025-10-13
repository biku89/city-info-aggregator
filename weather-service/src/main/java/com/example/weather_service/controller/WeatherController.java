package com.example.weather_service.controller;

import com.example.weather_service.model.WeatherDTO;
import com.example.weather_service.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/internal/weather")
    public WeatherDTO getWeather(@RequestParam double lat, @RequestParam double lon, @RequestParam(defaultValue = "metric") String units){
        return weatherService.getWeather(lat, lon,units);
    }
}
