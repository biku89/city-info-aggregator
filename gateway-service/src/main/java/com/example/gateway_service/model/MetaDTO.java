package com.example.gateway_service.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public record MetaDTO(
        LocalDateTime requestAt,
        List<String> sources
) {
}
