package com.example.city_service.service;

import com.example.city_service.clientNominatim.model.NominatimResponseDTO;
import com.example.city_service.exception.NotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CityServiceValidator {
    public static void cityNotFound(List<NominatimResponseDTO> nominationResponseDTO) {
        if (nominationResponseDTO == null || nominationResponseDTO.isEmpty()) {
            throw new NotFoundException("City not Found");

        }
    }
}
