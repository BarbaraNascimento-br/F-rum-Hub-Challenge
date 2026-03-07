package com.alura.ForumHub.dto;

import com.alura.ForumHub.enums.EstadoDoTopico;
import jakarta.validation.constraints.NotBlank;

public record TopicUpdateDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,

        EstadoDoTopico status
) {
}
