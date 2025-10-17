package com.example.gateway_service.fallback;

import com.example.gateway_service.client.InfoClient;
import com.example.gateway_service.model.InfoResponseDTO;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InfoClientFallback implements FallbackFactory<InfoClient> {
    @Override
    public InfoClient create(Throwable cause) {
        return new InfoClient() {
            @Override
            public InfoResponseDTO getInfo(double lat, double lon, String lang, int limit) {
                return InfoResponseDTO.builder()
                        .info(List.of())
                        .fx(null)
                        .build();
            }
        };
    }
}
