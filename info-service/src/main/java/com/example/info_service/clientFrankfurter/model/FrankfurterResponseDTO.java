package com.example.info_service.clientFrankfurter.model;

import java.util.Map;

public record FrankfurterResponseDTO(
        double amount,
        String base,
        String date,
        Map<String, Double> rates
) {
}
