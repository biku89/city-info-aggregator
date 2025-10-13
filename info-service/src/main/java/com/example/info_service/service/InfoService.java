package com.example.info_service.service;

import com.example.info_service.ClientWiki.WikipediaClient;
import com.example.info_service.ClientWiki.model.WikipediaResponseDTO;
import com.example.info_service.clientFrankfurter.FrankfurterClient;
import com.example.info_service.clientFrankfurter.model.FrankfurterResponseDTO;
import com.example.info_service.clientNominatim.NominatimClient;
import com.example.info_service.clientNominatim.model.NominatimResponseDTO;
import com.example.info_service.exception.IncorrectCoordinatesException;
import com.example.info_service.mapper.InfoMapper;
import com.example.info_service.model.FxDTO;
import com.example.info_service.model.InfoDTO;
import com.example.info_service.model.InfoResponseDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InfoService {
    private final WikipediaClient wikipediaClient;
    private final InfoMapper infoMapper;
    private final NominatimClient nominatimClient;
    private final FrankfurterClient frankfurterClient;


    public InfoResponseDTO getInfo(double lat, double lon, String lang, int limit) {
        InfoServiceValidator.incorrectLat(lat);
        InfoServiceValidator.incorrectLon(lon);

        String cityName = reverseLookup(lat, lon);

        String localCurrency = getCurrencyForCountry(lat, lon);

        WikipediaResponseDTO responseDTO = wikipediaClient.getInfo(cityName, limit);
        List<InfoDTO> infoDTOList = infoMapper.toDTOlist(responseDTO.pages());

        FxDTO fxDTO = infoMapper.toDTOfx(frankfurterClient.getRates(localCurrency, "EUR,USD,PLN"));

        return new InfoResponseDTO(infoDTOList, fxDTO);

    }

    private String reverseLookup(double lat, double lon) {
        NominatimResponseDTO responseDTO = nominatimClient.getReverse(lat, lon, "json");
        return responseDTO.address().city();
    }

    private String getCurrencyForCountry(double lat, double lon) {
        NominatimResponseDTO response = nominatimClient.getReverse(lat, lon, "json");
        String country = response.address().country_code();
        return switch (country.toUpperCase()) {
            case "PL" -> "PLN";
            case "US" -> "USD";
            case "GB" -> "GBP";
            case "DE" -> "EUR";
            case "CZ" -> "CZK";
            case "SE" -> "SEK";
            default -> "EUR";
        };
    }
}
