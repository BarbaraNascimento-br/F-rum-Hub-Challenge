package com.alura.ForumHub.entity;

import com.alura.ForumHub.enums.EstadoDoTopico;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "topicos" +
        "" +
        "")
public class TopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "mensagem", nullable = false)
    private String mensagem;

    @Column(name = "data", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "status", nullable = false)
    private EstadoDoTopico status;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private UserEntity user;

    public TopicEntity(String titulo, String mensagem, UserEntity user) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.status = EstadoDoTopico.ABERTO;
        this.dataCriacao = LocalDateTime.now();
        this.user = user;
    }
}
