package com.alura.ForumHub.dto;

import com.alura.ForumHub.enums.EstadoDoTopico;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

public record TopicResponseDTO(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCricao,
        EstadoDoTopico status,
        String nomeUser
) {
}
