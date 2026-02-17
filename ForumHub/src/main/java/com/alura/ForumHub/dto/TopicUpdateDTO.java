package com.alura.ForumHub.dto;

import com.alura.ForumHub.enums.EstadoDoTopico;

public record TopicUpdateDTO(
        String titulo,
        String mensagem,
        EstadoDoTopico status
) {
}
