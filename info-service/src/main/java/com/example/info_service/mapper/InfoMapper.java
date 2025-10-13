package com.example.info_service.mapper;

import com.example.info_service.ClientWiki.model.WikiPage;
import com.example.info_service.ClientWiki.model.WikipediaResponseDTO;
import com.example.info_service.clientFrankfurter.model.FrankfurterResponseDTO;
import com.example.info_service.model.FxDTO;
import com.example.info_service.model.InfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InfoMapper {
    @Mapping(target = "title", source = "title")
    @Mapping(target = "snippet", source = "snippet")
    @Mapping(target = "url", expression = "java(\"https://pl.wikipedia.org/wiki/\" + page.key())")
    @Mapping(target = "imageUrl", source = "thumbnail.url")
    InfoDTO toDTO(WikiPage page);

    List<InfoDTO> toDTOlist(List<WikiPage> pages);

    @Mapping(target = "localCurrency", source = "base")
    @Mapping(target = "rates", source = "rates")
    @Mapping(target = "source", constant = "Frankfurter.app")
    FxDTO toDTOfx(FrankfurterResponseDTO responseDTO);
}
