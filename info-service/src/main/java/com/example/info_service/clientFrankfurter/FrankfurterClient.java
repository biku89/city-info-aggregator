package com.example.info_service.clientFrankfurter;

import com.example.info_service.clientFrankfurter.model.FrankfurterResponseDTO;
import com.example.info_service.model.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "frankfurterClient", configuration = FeignConfig.class)
public interface FrankfurterClient {
    @GetMapping("/latest")
    FrankfurterResponseDTO getRates(
            @RequestParam("from") String from,
            @RequestParam("to") String to
    );
}
