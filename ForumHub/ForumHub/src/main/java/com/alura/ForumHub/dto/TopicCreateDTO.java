package com.alura.ForumHub.dto;

public record TopicCreateDTO(
        String titulo,
        String mensagem,
        Long userId
) {
}
