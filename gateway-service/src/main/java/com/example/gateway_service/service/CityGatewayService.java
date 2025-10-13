package com.example.gateway_service.service;

import com.example.gateway_service.client.CityClient;
import com.example.gateway_service.client.InfoClient;
import com.example.gateway_service.client.WeatherClient;
import com.example.gateway_service.exception.NotFoundException;
import com.example.gateway_service.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityGatewayService {
    private final CityClient cityClient;
    private final InfoClient infoClient;
    private final WeatherClient weatherClient;

    public CityAggregatorResponseDTO getAggregatorCity(String city, String lang, String units, int limit){
        CityDTO cityDTO = cityClient.getCity(city);
        WeatherDTO weatherDTO = weatherClient.getWeather(cityDTO.lat(),cityDTO.lon(),units);
        InfoResponseDTO infoResponseDTO = infoClient.getInfo(cityDTO.lat(), cityDTO.lon(),lang, limit);

        MetaDTO metaDTO = new MetaDTO(LocalDateTime.now(), List.of("OpenWeather","Wikipedia","Frankfurter"));

        return new CityAggregatorResponseDTO(cityDTO,weatherDTO,infoResponseDTO.info(),infoResponseDTO.fx(),metaDTO);
    }
}
