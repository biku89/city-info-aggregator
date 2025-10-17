package com.example.gateway_service.model;

import lombok.Builder;

import java.util.List;

@Builder
public record InfoResponseDTO(List<InfoDTO> info, FxDTO fx){
}
