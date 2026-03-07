package com.alura.ForumHub.mapper;

import com.alura.ForumHub.dto.TopicCreateDTO;
import com.alura.ForumHub.dto.TopicResponseDTO;
import com.alura.ForumHub.entity.TopicEntity;
import com.alura.ForumHub.entity.UserEntity;
import com.alura.ForumHub.enums.EstadoDoTopico;

import java.time.LocalDateTime;

public class TopicMapper {
    //Entity -> DTO (topico)
    public static TopicResponseDTO toDTO (TopicEntity entity){
        return new TopicResponseDTO(
                entity.getId(),
                entity.getTitulo(),
                entity.getMensagem(),
                entity.getDataCriacao(),
                entity.getStatus(),
                entity.getUser().getNomeUser()
        );
    }

    // DTO -> Entity (topico)
    public static TopicEntity toEntity (TopicCreateDTO dto, UserEntity user){
        TopicEntity entity1 = new TopicEntity();
        entity1.setTitulo(dto.titulo());
        entity1.setMensagem(dto.mensagem());
        entity1.setDataCriacao(LocalDateTime.now());
        entity1.setStatus(EstadoDoTopico.ABERTO);
        entity1.setUser(user);
        return entity1;
    }

}
