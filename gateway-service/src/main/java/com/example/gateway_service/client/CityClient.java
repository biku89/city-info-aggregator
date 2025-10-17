package com.example.gateway_service.client;

import com.example.gateway_service.model.CityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cityClient")
public interface CityClient {

    @GetMapping
    CityDTO getCity(@RequestParam("query") String query);
}
