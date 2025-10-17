package com.example.info_service.ClientWiki.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WikiPage(
        String title,
        @JsonProperty("description")
        String snippet,
        String key,
        Thumbnail thumbnail
) {
}
