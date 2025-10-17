package com.example.city_service.nominatimClient;

import com.example.city_service.clientNominatim.NominatimClient;
import com.example.city_service.clientNominatim.model.AddressDTO;
import com.example.city_service.clientNominatim.model.NominatimResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureWireMock(port = 8585)
@SpringBootTest
public class NominatimClientTest {
    @Autowired
    NominatimClient nominatimClient;
    @Autowired
    WireMockServer wireMockServer;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void shouldGetCity() throws JsonProcessingException {
        String query = "Łódź";
        List<NominatimResponseDTO> nominatimResponseDTO = new ArrayList<>();
        NominatimResponseDTO responseDTO = new NominatimResponseDTO("20","20", new AddressDTO("Łódź", "Poland", "PL"));
        nominatimResponseDTO.add(responseDTO);

        wireMockServer.stubFor(get(urlPathEqualTo("/search"))
                .withQueryParam("q", equalTo(query))
                .withQueryParam("format", equalTo("json"))
                .withQueryParam("addressdetails", equalTo("1"))
                .withQueryParam("limit", equalTo("1"))
                .willReturn(aResponse()
                        .withHeader("content-type", "application/json")
                        .withBody(objectMapper.writeValueAsString(List.of(responseDTO)))));

        List<NominatimResponseDTO> result = nominatimClient.getCity(query,"json",1,1);

        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals("Łódź", result.getFirst().addressDTO().city())
        );
    }
}
