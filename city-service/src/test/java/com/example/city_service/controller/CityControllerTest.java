package com.example.city_service.controller;

import com.example.city_service.clientNominatim.model.AddressDTO;
import com.example.city_service.clientNominatim.model.NominatimResponseDTO;
import com.example.city_service.mapper.CityMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureWireMock(port = 8585)
@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerTest {
    @Autowired
    WireMockServer wireMockServer;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    @Test
    void getCity_shouldReturnCity() throws Exception {
        String query = "Łódź";
        NominatimResponseDTO nominatimResponseDTO = NominatimResponseDTO
                .builder()
                .lat("20")
                .lon("50")
                .addressDTO(new AddressDTO("Łódź", "Poland", "PL"))
                .build();

        wireMockServer.stubFor(get(urlPathEqualTo("/search"))
                .withQueryParam("q", equalTo("Łódź"))
                .withQueryParam("format", equalTo("json"))
                .withQueryParam("addressdetails", equalTo("1"))
                .withQueryParam("limit", equalTo("1"))
                .willReturn(aResponse()
                        .withHeader("content-type", "application/json")
                        .withBody(objectMapper.writeValueAsString(List.of(nominatimResponseDTO)))));

        mockMvc.perform(MockMvcRequestBuilders.get("/internal/city").param("query", query))
                .andDo(print());
    }
}
