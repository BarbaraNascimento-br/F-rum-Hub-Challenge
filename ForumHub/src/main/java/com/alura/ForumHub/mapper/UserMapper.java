package com.alura.ForumHub.mapper;

import com.alura.ForumHub.dto.UserCreateDTO;
import com.alura.ForumHub.dto.UserReponseDTO;
import com.alura.ForumHub.entity.UserEntity;

public class UserMapper {
    //Entity -> DTO (usuário)
    public static UserReponseDTO toDTO(UserEntity userEntity){
        return new UserReponseDTO(
                userEntity.getId(),
                userEntity.getNomeUser(),
                userEntity.getCurso(),
                userEntity.getEmail(),
                userEntity.getSenha()
        );
    }

    // DTO -> Entity (usuários)
    public static UserEntity toEntity(UserCreateDTO dto){
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setNomeUser(dto.nomeUser());
        userEntity1.setCurso(dto.curso());
        userEntity1.setEmail(dto.email());
        userEntity1.setSenha(dto.senha());
        return userEntity1;
    }
}
