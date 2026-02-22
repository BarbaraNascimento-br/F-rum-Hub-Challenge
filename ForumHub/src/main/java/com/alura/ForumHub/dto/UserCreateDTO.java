package com.alura.ForumHub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateDTO(
        @NotBlank(message = "Nome é obrigadorio")
        String nomeUser,
        @NotBlank(message = "Nome do curso é obrigadorio")
        String curso,
        @Email(message = "Email inválido")
        String email,
        @NotBlank(message = "É obrigadorio criar uma senha")
        @Size(min = 6, max = 10, message = "A senha deve ter no mínimo 6 digitos e no máximo 10 digitos")
        String senha
) {
}
