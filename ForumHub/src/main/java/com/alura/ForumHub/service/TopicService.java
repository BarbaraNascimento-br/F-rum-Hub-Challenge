package com.alura.ForumHub.service;

import com.alura.ForumHub.dto.*;
import com.alura.ForumHub.entity.TopicEntity;
import com.alura.ForumHub.entity.UserEntity;
import com.alura.ForumHub.enums.EstadoDoTopico;
import com.alura.ForumHub.repository.TopicRepository;
import com.alura.ForumHub.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicService {

    private TopicEntity entity;
    private UserEntity userEntity;
    private UserRepository userRepository;
    private TopicRepository topicRepository;


    //Entity -> DTO (usuário)
    public UserReponseDTO toDTO(UserEntity userEntity){
        return new UserReponseDTO(
                userEntity.getId(),
                userEntity.getNomeUser(),
                userEntity.getCurso()
        );
    }

    // DTO -> Entity (usuários)
    public UserEntity toEntity(UserCreateDTO dto){
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setNomeUser(dto.nomeUser());
        userEntity1.setCurso(dto.curso());
        return userEntity1;
    }


    //Entity -> DTO (topico)
    public TopicResponseDTO toDTO (TopicEntity entity){
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
    public TopicEntity toEntity (TopicCreateDTO dto, UserEntity user){
        TopicEntity entity1 = new TopicEntity();
        entity1.setTitulo(dto.titulo());
        entity1.setMensagem(dto.mensagem());
        entity1.setDataCriacao(LocalDateTime.now());
        entity1.setStatus(EstadoDoTopico.ABERTO);
        entity1.setUser(user);
        return entity1;
    }

    //CRIANDO UM NOVO TOPICO
    public TopicResponseDTO criarTopic(TopicCreateDTO dto){
        UserEntity user = userRepository.findById(dto.userId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        TopicEntity topicEntity = toEntity(dto, user);
        topicRepository.save(topicEntity);
        return toDTO(topicEntity);
    }

    //LISTANDO OS TOPICOS
    public List<TopicResponseDTO> listarTopic(){
        return topicRepository.findAll().stream().map(this::toDTO).toList();
    }

    //ATUALLIZANDO O TOPICO
    public TopicResponseDTO atualizarTopico(Long id, TopicUpdateDTO dto){
        TopicEntity topicEntity = topicRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND,"Tópico não encontrado"));
        topicEntity.setTitulo(dto.titulo());
        topicEntity.setMensagem(dto.mensagem());
        topicEntity.setStatus(EstadoDoTopico.FECHADO);
        return toDTO(topicEntity);
    }

    //DELETANDO UM TOPICO
    public void deletarTopico (Long id){
        topicRepository.deleteById(id);
    }
}
