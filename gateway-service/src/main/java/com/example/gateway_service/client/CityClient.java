package com.example.gateway_service.client;

import com.example.gateway_service.model.CityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cityClient", url = "http://localhost:8081/internal/city")
public interface CityClient {
    @GetMapping
    CityDTO getCity(@RequestParam("query") String query);
}
