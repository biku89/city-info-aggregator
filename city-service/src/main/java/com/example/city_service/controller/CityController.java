package com.example.city_service.controller;

import com.example.city_service.model.CityDTO;
import com.example.city_service.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/city")
public class CityController {
    private final CityService cityService;
    @GetMapping
    public CityDTO getCity(@RequestParam String query){
        return cityService.getCity(query);
    }
}
