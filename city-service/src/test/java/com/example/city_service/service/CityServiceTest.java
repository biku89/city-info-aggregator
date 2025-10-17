package com.example.city_service.service;

import com.example.city_service.clientNominatim.NominatimClient;
import com.example.city_service.clientNominatim.model.AddressDTO;
import com.example.city_service.clientNominatim.model.NominatimResponseDTO;
import com.example.city_service.exception.NotFoundException;
import com.example.city_service.mapper.CityMapper;
import com.example.city_service.model.CityDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CityServiceTest {
    NominatimClient nominatimClient;
    CityMapper cityMapper;
    CityDTO cityDTO;
    CityService cityService;

    @BeforeEach
    void setUp(){
        this.nominatimClient = Mockito.mock(NominatimClient.class);
        this.cityMapper = Mappers.getMapper(CityMapper.class);
        this.cityDTO = Mockito.mock(CityDTO.class);
        this.cityService = new CityService(cityMapper, nominatimClient);
    }

    @Test
    void getCity_CityExists_ReturnedCityDTO(){
        List<NominatimResponseDTO> nominatimResponseDTO = new ArrayList<>();
        NominatimResponseDTO responseDTO = new NominatimResponseDTO("40","20", new AddressDTO("Łódź", "Poland", "PL"));
        nominatimResponseDTO.add(responseDTO);

        when(nominatimClient.getCity("Łódź","json",1,1)).thenReturn(nominatimResponseDTO);

        CityDTO result = cityService.getCity("Łódź");

        Assertions.assertAll(
                () -> Assertions.assertEquals("Łódź", result.name()),
                () -> Assertions.assertEquals("PL", result.country()),
                () -> Assertions.assertEquals(40, result.lat()),
                () -> Assertions.assertEquals(20, result.lon())
        );
    }

    @Test
    void getCity_CityNotExists_ReturnedException(){
        String query = "Łódź";
        when(nominatimClient.getCity("Łódź","json",1,1)).thenReturn(Collections.emptyList());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> cityService.getCity(query));

        assertAll(
                () -> assertEquals("City not Found", exception.getMessage()),
                () -> assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus())
        );


    }
}
