package com.example.gateway_service.client;

import com.example.gateway_service.fallback.WeatherClientFallback;
import com.example.gateway_service.model.WeatherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherClient", fallbackFactory = WeatherClientFallback.class)
public interface WeatherClient {

    @GetMapping
    WeatherDTO getWeather(
            @RequestParam("lat") double lat,
            @RequestParam("lon") double lon,
            @RequestParam("units") String units
    );
}
