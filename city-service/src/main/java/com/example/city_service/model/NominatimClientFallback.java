package com.example.city_service.model;

import com.example.city_service.clientNominatim.NominatimClient;
import com.example.city_service.clientNominatim.model.NominatimResponseDTO;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NominatimClientFallback implements FallbackFactory<NominatimClient> {
    @Override
    public NominatimClient create(Throwable cause) {
        return new NominatimClient() {
            @Override
            public List<NominatimResponseDTO> getCity(String city, String format, int addressdetails, int limit) {
                return List.of();
            }
        };
    }
}
