package com.example.city_service.clientNominatim.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record NominatimResponseDTO(
        String lat,
        String  lon,
        @JsonProperty("address")
        AddressDTO addressDTO
        ){
}
