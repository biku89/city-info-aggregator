package com.example.gateway_service.fallback;

import com.example.gateway_service.client.WeatherClient;
import com.example.gateway_service.model.WeatherDTO;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeatherClientFallback implements FallbackFactory<WeatherClient> {
    @Override
    public WeatherClient create(Throwable cause) {
        return new WeatherClient() {
            @Override
            public WeatherDTO getWeather(double lat, double lon, String units) {
                return WeatherDTO.builder()
                        .temperature(null)
                        .condition(null)
                        .forecastHours(List.of())
                        .feelsLike(null)
                        .degraded(true)
                        .build();
            }
        };
    }
}
