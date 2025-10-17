package com.example.info_service.model;

import java.util.Map;

public record FxDTO(
        String localCurrency,
        Map<String, Double> rates,
        String source
) {
}
