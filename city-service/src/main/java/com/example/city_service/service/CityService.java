package com.example.city_service.service;

import com.example.city_service.clientNominatim.NominatimClient;
import com.example.city_service.clientNominatim.model.NominatimResponseDTO;
import com.example.city_service.exception.NotFoundException;
import com.example.city_service.mapper.CityMapper;
import com.example.city_service.model.CityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityMapper cityMapper;
    private final NominatimClient nominatimClient;

    public CityDTO getCity(String query) {
        List<NominatimResponseDTO> nominationResponseDTO = nominatimClient.getCity(query, "json", 1, 1);
        CityServiceValidator.cityNotFound(nominationResponseDTO);
        return cityMapper.toDTO(nominationResponseDTO.getFirst());

    }
}

