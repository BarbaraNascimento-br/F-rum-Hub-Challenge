package com.alura.ForumHub.service;


import com.alura.ForumHub.dto.UserReponseDTO;
import com.alura.ForumHub.entity.UserEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class TokenService {
    @Value("$(api.security.token.secret}")
    private String secret;



    public String gerarToken(UserEntity user){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API ForumHub")
                    .withSubject(user.getEmail()) //identifica o usuário no token
                    .withExpiresAt(dataExpiracao()) // quando o token deixa de ser válido
                    .sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerrar token jwt", exception);
        }
    }

    public String getSubject(String tokenJWT){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return  JWT.require(algoritmo)
                    .withIssuer("API ForumHub")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        }catch (JWTCreationException e){
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant dataExpiracao() {
        return Instant.now().plusSeconds(7200);
    }
}
