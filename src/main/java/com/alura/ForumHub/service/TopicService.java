package com.alura.ForumHub.service;

import com.alura.ForumHub.dto.*;
import com.alura.ForumHub.entity.TopicEntity;
import com.alura.ForumHub.entity.UserEntity;
import com.alura.ForumHub.enums.EstadoDoTopico;
import com.alura.ForumHub.mapper.TopicMapper;
import com.alura.ForumHub.repository.TopicRepository;
import com.alura.ForumHub.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final UserRepository userRepository;
    private final TopicRepository topicRepository;

    @Transactional
    public TopicResponseDTO criarTopic(TopicCreateDTO dto){
        UserEntity user = userRepository.findById(dto.userId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        TopicEntity topicEntity = TopicMapper.toEntity(dto, user);
        topicRepository.save(topicEntity);
        return TopicMapper.toDTO(topicEntity);
    }

    public List<TopicResponseDTO> listarTopics(){
        return topicRepository.findAll().stream().map(TopicMapper::toDTO).toList();
    }

    public TopicResponseDTO listarTopicPorId (Long id){
        TopicEntity entity = topicRepository.findById(id).orElseThrow(()->  new ResponseStatusException(HttpStatus.NOT_FOUND,"Tópico não encontrado"));
        return TopicMapper.toDTO(entity);
    }
    @Transactional
    public TopicResponseDTO atualizarTopico(Long id, TopicUpdateDTO dto){
        TopicEntity topicEntity = topicRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND,"Tópico não encontrado"));
        topicEntity.setTitulo(dto.titulo());
        topicEntity.setMensagem(dto.mensagem());
        topicEntity.setStatus(EstadoDoTopico.ABERTO);
        return TopicMapper.toDTO(topicEntity);
    }
    @Transactional
    public void deletarTopico (Long id){
        topicRepository.deleteById(id);
    }
}
