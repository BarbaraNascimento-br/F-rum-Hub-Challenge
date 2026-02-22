package com.alura.ForumHub.controller;

import com.alura.ForumHub.dto.TopicCreateDTO;
import com.alura.ForumHub.dto.TopicResponseDTO;
import com.alura.ForumHub.dto.UserCreateDTO;
import com.alura.ForumHub.dto.UserReponseDTO;
import com.alura.ForumHub.entity.TopicEntity;
import com.alura.ForumHub.service.TopicService;
import com.alura.ForumHub.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forumhub")
@RequiredArgsConstructor
public class ForumHubController {

    private final TopicService topicService;
    private final UserService userService;

    @PostMapping("/topic/create")
    public ResponseEntity<TopicResponseDTO> criarTopico (@RequestBody TopicCreateDTO dto){
        TopicResponseDTO responseDTO = topicService.criarTopic(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TopicResponseDTO>> listarTopico (){
        return ResponseEntity.ok(topicService.listarTopics());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<TopicResponseDTO> listarPorId(@PathVariable Long id){
        return ResponseEntity.ok(topicService.listarTopicPorId(id));
    }

    @PostMapping("/user/create")
    public ResponseEntity<UserReponseDTO> criandoUsuario(@RequestBody  @Valid UserCreateDTO dto){
        UserReponseDTO userReponseDTO = userService.criarUsuario(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(userReponseDTO);
    }
    


}
