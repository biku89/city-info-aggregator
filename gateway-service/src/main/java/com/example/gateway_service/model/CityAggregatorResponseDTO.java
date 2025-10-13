package com.example.gateway_service.model;

import java.util.List;

public record CityAggregatorResponseDTO(CityDTO city,
                                        WeatherDTO weather,
                                        List<InfoDTO> info,
                                        FxDTO fx,
                                        MetaDTO meta) {
}
