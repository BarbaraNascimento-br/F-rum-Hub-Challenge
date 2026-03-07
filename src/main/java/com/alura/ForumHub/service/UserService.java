package com.alura.ForumHub.service;

import com.alura.ForumHub.dto.UserCreateDTO;
import com.alura.ForumHub.dto.UserReponseDTO;
import com.alura.ForumHub.entity.UserEntity;
import com.alura.ForumHub.mapper.UserMapper;
import com.alura.ForumHub.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder;

    @Transactional
    public UserReponseDTO criarUsuario(UserCreateDTO dto){
        UserEntity userEntity1 = UserMapper.toEntity(dto);
        userEntity1.setSenha(passwordEncoder.encode(userEntity1.getSenha()));
        userRepository.save(userEntity1);
        return UserMapper.toDTO(userEntity1);
    }



}
