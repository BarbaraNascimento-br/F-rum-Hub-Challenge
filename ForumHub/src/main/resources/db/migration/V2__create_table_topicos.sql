CREATE TABLE topicos(
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensagem TEXT  NOT NULL,
    data TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,

    autor_id BIGINT NOT NULL,
    CONSTRAINT fk_topico_usuario
        FOREIGN KEY(autor_id)
        REFERENCES usuarios(id)
        ON DELETE CASCADE
);
