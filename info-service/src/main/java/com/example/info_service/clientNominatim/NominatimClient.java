package com.example.info_service.clientNominatim;

import com.example.info_service.clientNominatim.model.NominatimResponseDTO;
import com.example.info_service.model.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "nominatimClient", configuration = FeignConfig.class)
public interface NominatimClient {
    @GetMapping(value = "/reverse")
    NominatimResponseDTO getReverse(
            @RequestParam("lat") double lat,
            @RequestParam("lon") double lon,
            @RequestParam(value = "format", defaultValue = "json") String format
    );

}
