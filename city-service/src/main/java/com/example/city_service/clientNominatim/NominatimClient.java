package com.example.city_service.clientNominatim;

//endpoint api https://nominatim.openstreetmap.org/search?<params>

import com.example.city_service.clientNominatim.model.NominatimResponseDTO;
import com.example.city_service.model.FeignConfig;
import com.example.city_service.model.NominatimClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "nominatimClient",configuration = FeignConfig.class, fallbackFactory = NominatimClientFallback.class)
public interface NominatimClient {
    @GetMapping("/search")
    List<NominatimResponseDTO> getCity(
            @RequestParam("q") String city,
            @RequestParam("format") String format,
            @RequestParam("addressdetails") int addressdetails,
            @RequestParam("limit") int limit
    );
}
