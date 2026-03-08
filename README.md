🚀 ForumHub API

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-Framework-green)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Flyway](https://img.shields.io/badge/Flyway-Migrations-red)
![Maven](https://img.shields.io/badge/Maven-Build-red)


API REST desenvolvida em Java com Spring Boot para gerenciamento de tópicos de um fórum.

O sistema permite:

- Criar tópicos
- Listar tópicos
- Atualizar tópicos
- Excluir tópicos
- Autenticação com JWT
- Proteção de rotas com Spring Security

Este projeto foi desenvolvido para praticar construção de APIs REST, autenticação e boas práticas com Spring Boot.

---

🏗️ Arquitetura do Projeto

A aplicação segue uma arquitetura em camadas:

controller
service
repository
model
dto
security
config

Explicação das camadas

Controller

Responsável por receber as requisições HTTP.

Service

Contém a lógica de negócio da aplicação.

Repository

Responsável pela comunicação com o banco de dados.

DTO

Utilizado para transferência de dados entre as camadas.

Security

Configuração do Spring Security e autenticação JWT.

---

🛠️ Tecnologias utilizadas

- Java
- Spring Boot
- Spring Security
- JWT
- PostgreSQL
- Flyway
- Maven
- Insomnia

---

🔐 Autenticação com JWT

A API utiliza JWT (JSON Web Token) para proteger as rotas.

Fluxo de autenticação:

1️⃣ Usuário faz login
2️⃣ API gera um token JWT
3️⃣ O token é enviado nas requisições protegidas

Header obrigatório:

Authorization: Bearer SEU_TOKEN

---

🧪 Testando a API no Insomnia

1️⃣ Fazer login

POST

http://localhost:8080/login

Body:
```json
{
  "email": "usuario@gmail.com",
  "senha": "123456"
}
```

Resposta esperada:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5..."
}
```

Copie o token retornado.

---

2️⃣ Configurar o token

No Insomnia, adicione no Header:

Authorization: Bearer SEU_TOKEN

---

3️⃣ Criar um tópico

POST

http://localhost:8080/topicos

Body:
```json
{
	"titulo" : "Error no insomnia",
	"mensagem" : "Meu teste no insomnia deu erro 401",
	"userId" : 7
}
```

Resposta:

201 Created

---

4️⃣ Listar tópicos

GET

http://localhost:8080/topicos

Resposta:
```json
[
 {
	"id": 1,
	"titulo": "Error no insomnia",
	"mensagem": "Meu teste no insomnia deu erro 401",
	"dataCricao": "2026-02-27T12:45:54.022176",
	"status": "ABERTO",
	"nomeUser": "usuário"
}
]
```
---

5️⃣ Atualizar um tópico

PUT

http://localhost:8080/topicos/{id}

Body:
```json
{
  "titulo": "Erro resolvido",
  "mensagem": "Consegui resolver o erro"
}
```

---

6️⃣ Deletar um tópico

DELETE

http://localhost:8080/topicos/{id}

Resposta esperada:

204 No Content

---

📊 Status HTTP utilizados

Código| Significado
200| OK
201| Criado
204| Sem conteúdo
400| Requisição inválida
401| Não autorizado

---

🚀 Melhorias futuras

- Paginação de tópicos
- Sistema de respostas
- Documentação com Swagger
- Deploy em nuvem
- 
---

👩‍💻 Autor

Bárbara Isabella

Projeto desenvolvido durante os estudos de:

- Java
- Spring Boot
- APIs REST
- Segurança com JWT
