package com.example.weather_service.service;

import com.example.weather_service.clientOpenWeather.OpenWeatherClient;
import com.example.weather_service.clientOpenWeather.model.OpenWeatherForecastResponseDT;
import com.example.weather_service.clientOpenWeather.model.OpenWeatherResponseDTO;
import com.example.weather_service.exception.IncorrectCoordinatesException;
import com.example.weather_service.exception.NotFoundException;
import com.example.weather_service.mapper.WeatherMapper;
import com.example.weather_service.model.ForecastHourDTO;
import com.example.weather_service.model.WeatherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import java.awt.*;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final OpenWeatherClient openWeatherClient;
    private final String apiKey = "49e50d38c27e9663510712869a9d8f7f";
    private final WeatherMapper weatherMapper;

    public WeatherDTO getWeather(double lat, double lon,String units){
        WeatherValidator.incorrectLat(lat);
        WeatherValidator.incorrectLon(lon);

        OpenWeatherResponseDTO current = openWeatherClient.getWeather(lat,lon,"metric", apiKey);
        if (current == null){
            throw new NotFoundException("Current weather not found");
        }
        OpenWeatherForecastResponseDT forecastResponseDT= openWeatherClient.getForecast(lat,lon,"metric", apiKey);
        if (forecastResponseDT == null){
            throw new NotFoundException("ForecastHour not found");
        }

        List<ForecastHourDTO> forecastHourDTOS = forecastResponseDT
                .list()
                .stream()
                .limit(5)
                .map(weatherMapper::toDTOforecast).toList();

        WeatherDTO dto = weatherMapper.toDTO(current);

        return new WeatherDTO(dto.temperature(),
                dto.feelsLike(),
                dto.condition(),
                forecastHourDTOS);
    }
}
