package com.example.weather_service.clientOpenWeather;

import com.example.weather_service.clientOpenWeather.model.OpenWeatherForecastResponseDT;
import com.example.weather_service.clientOpenWeather.model.OpenWeatherResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "openWeatherClient")
public interface OpenWeatherClient {
    @GetMapping("/weather")
    OpenWeatherResponseDTO getWeather(
            @RequestParam("lat") Double lat,
            @RequestParam("lon") Double lon,
            @RequestParam("units") String units,
            @RequestParam("appid") String apiKey
    );

    @GetMapping("/forecast")
    OpenWeatherForecastResponseDT getForecast(
            @RequestParam("lat") Double lat,
            @RequestParam("lon") Double lon,
            @RequestParam("units") String units,
            @RequestParam("appid") String apiKey
    );
}


