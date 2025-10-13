package com.example.info_service.ClientWiki.model;

import java.util.List;

public record WikipediaResponseDTO(
        List<WikiPage> pages
) {
}
