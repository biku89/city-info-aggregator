package com.example.city_service.clientNominatim.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddressDTO(
        String city,
        String country,
        @JsonProperty("country_code")
        String countryCode) {

        public String countryCode(){
                return countryCode != null ? countryCode.toUpperCase() : null;
        }
}
