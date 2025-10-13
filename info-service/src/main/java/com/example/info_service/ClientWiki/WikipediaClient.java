package com.example.info_service.ClientWiki;

import com.example.info_service.ClientWiki.model.WikipediaResponseDTO;
import com.example.info_service.model.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "wikipediaClient", configuration = FeignConfig.class)
public interface WikipediaClient {
    @GetMapping( value = "/search/page",headers = "User-Agent=city-info-aggregator/1.0")
    WikipediaResponseDTO getInfo(
            @RequestParam ("q") String query,
            @RequestParam ("limit") int limit
    );
}
