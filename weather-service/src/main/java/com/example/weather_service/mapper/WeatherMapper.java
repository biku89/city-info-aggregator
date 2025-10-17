package com.example.weather_service.mapper;

import com.example.weather_service.clientOpenWeather.model.ForecastDTO;
import com.example.weather_service.clientOpenWeather.model.OpenWeatherForecastResponseDT;
import com.example.weather_service.clientOpenWeather.model.OpenWeatherResponseDTO;
import com.example.weather_service.model.ForecastHourDTO;
import com.example.weather_service.model.WeatherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface WeatherMapper {
    @Mapping(source = "main.temperature", target = "temperature")
    @Mapping(source = "main.feelsLike", target = "feelsLike")
    @Mapping(source = "description", target = "condition")
    WeatherDTO toDTO(OpenWeatherResponseDTO openWeatherResponseDTO);
    @Mapping(source = "time", target = "t")
    @Mapping(source = "main.temp", target = "temp")
    ForecastHourDTO toDTOforecast(ForecastDTO forecastDTO);

}
