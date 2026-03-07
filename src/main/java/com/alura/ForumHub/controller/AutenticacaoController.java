package com.alura.ForumHub.controller;

import com.alura.ForumHub.dto.DadosTokenDTO;
import com.alura.ForumHub.dto.UserLoginDTO;
import com.alura.ForumHub.dto.UserReponseDTO;
import com.alura.ForumHub.entity.UserEntity;
import com.alura.ForumHub.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired(required = true)
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid UserLoginDTO dto){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        var authenticaon = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((UserEntity) authenticaon.getPrincipal());
       return ResponseEntity.ok(new DadosTokenDTO(tokenJWT));

    }
}
