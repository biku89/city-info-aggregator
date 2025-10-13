package com.example.info_service.model;

public record InfoDTO(
        String title,
        String snippet,
        String url,
        String imageUrl
) {
}
