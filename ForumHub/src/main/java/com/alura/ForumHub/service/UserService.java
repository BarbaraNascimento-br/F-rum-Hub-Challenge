package com.alura.ForumHub.service;

import com.alura.ForumHub.dto.UserCreateDTO;
import com.alura.ForumHub.dto.UserReponseDTO;
import com.alura.ForumHub.entity.UserEntity;
import com.alura.ForumHub.mapper.UserMapper;
import com.alura.ForumHub.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserReponseDTO criarUsuario(UserCreateDTO dto){
        UserEntity userEntity1 = UserMapper.toEntity(dto);
        userRepository.save(userEntity1);
        return UserMapper.toDTO(userEntity1);
    }



}
