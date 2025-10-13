package com.example.gateway_service.model;

import java.util.List;

public record InfoResponseDTO (List<InfoDTO> info, FxDTO fx){
}
