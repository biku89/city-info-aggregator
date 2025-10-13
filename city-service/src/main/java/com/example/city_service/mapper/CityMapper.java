package com.example.city_service.mapper;

import com.example.city_service.clientNominatim.model.NominatimResponseDTO;
import com.example.city_service.model.CityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CityMapper {
    @Mapping(source = "addressDTO.city", target = "name")
    @Mapping(source = "addressDTO.countryCode", target = "country")
    CityDTO toDTO (NominatimResponseDTO nominationResponseDTO);
}
