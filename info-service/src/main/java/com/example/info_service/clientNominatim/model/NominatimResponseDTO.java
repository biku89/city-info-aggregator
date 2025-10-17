package com.example.info_service.clientNominatim.model;

public record NominatimResponseDTO(
        String display_name,
        Address address
){
    public record Address(String city, String town, String village, String country_code){

    }

}
