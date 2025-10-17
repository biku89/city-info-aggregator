package com.example.info_service.controller;

import com.example.info_service.model.InfoDTO;
import com.example.info_service.model.InfoResponseDTO;
import com.example.info_service.service.InfoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/info")
public class InfoController {
    private final InfoService infoService;

    @GetMapping()
    public InfoResponseDTO getInfo(@RequestParam double lat,
                                   @RequestParam double lon,
                                   @RequestParam(defaultValue = "pl") String lang,
                                   @RequestParam int limit){
        return infoService.getInfo(lat,lon,lang,limit);
    }
}
