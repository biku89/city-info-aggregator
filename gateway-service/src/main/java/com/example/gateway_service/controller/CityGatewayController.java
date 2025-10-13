package com.example.gateway_service.controller;

import com.example.gateway_service.model.CityAggregatorResponseDTO;
import com.example.gateway_service.service.CityGatewayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityGatewayController {
    private final CityGatewayService cityGatewayService;

    @GetMapping("/{city}")
    public CityAggregatorResponseDTO getCityData(
            @PathVariable String city,
            @RequestParam (defaultValue = "pl") String lang,
            @RequestParam(defaultValue = "metric") String units,
            @RequestParam(defaultValue = "3") int limit
    ){
        return cityGatewayService.getAggregatorCity(city,lang,units,limit);
    }
}
