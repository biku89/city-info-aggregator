package com.example.gateway_service.client;

import com.example.gateway_service.model.InfoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "infoClient",url = "http://localhost:8083/internal/info")
public interface InfoClient {
    @GetMapping
    InfoResponseDTO getInfo(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam String lang,
            @RequestParam int limit
    );
}
