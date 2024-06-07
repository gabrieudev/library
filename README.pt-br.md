# API REST para biblioteca

![Java](https://img.shields.io/badge/Java-21-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green) ![Spring Security](https://img.shields.io/badge/Spring%20Security-6-green) [![LinkedIn](https://img.shields.io/badge/Connect%20on-LinkedIn-blue)](https://www.linkedin.com/in/gabrieudev) ![GPL License](https://img.shields.io/badge/License-GPL-blue)

Seja bem vindo(a) ao meu projeto de **API REST para biblioteca**. O serviço usará este projeto para o back-end.

## Tabela de conteúdos

- [Introdução](#introdução)
- [Funcionalidades](#funcionalidades)
- [Tecnologias](#tecnologias)
- [Iniciando](#iniciando)
- [Configuração](#configuração)
- [Uso](#uso)
- [Endpoints](#endpoints)
- [Contribuições](#contribuições)
- [Contato](#contato)

## Introdução

O projeto de **API REST para biblioteca** foi criado com a proposta de fornecer operações CRUD para livros, categorias, empréstimos, autores, avaliações e usuários do sistema. Além disso, o projeto implementa autenticação com JWTs e autorização por meio de roles para os usuários, utilizando as melhores e mais atualizadas práticas do mercado para assegurar a integridade dos dados sensíveis. 

## Funcionalidades

- Envio de email para confirmação de cadastro dos usuários.
- Buscas utilizando paginação.
- Documentação com endpoints utilizando Swagger.
- Login de usuários com autenticação através de JWT.
- Autorização com roles para o controle de acesso de diferentes endpoints da API. 
- Senhas criptografadas utilizando as melhores práticas da indústria.
- Integração com o banco de dados PostgreSQL.

## Tecnologias

- ![Java](https://img.shields.io/badge/Java-21-orange): Linguagem de programação.
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green): Framework usado para a construção de aplicações voltadas à produção.
- ![Spring Security](https://img.shields.io/badge/Spring%20Security-6-green): Framework para segurança de aplicações Spring.
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue): Banco de dados relacional.

## Iniciando

Siga esses passos para executar o projeto na sua máquina:

1. Clone o repositório: `git clone https://github.com/gabrieudev/library.git`
2. Navegue para o diretório do projeto: `cd <caminho>`
3. Atualize as configurações gerais em `application.properties`.
4. Construa o projeto: `./mvnw clean install` (para Windows: `mvnw.cmd clean install`)
5. Execute a aplicação: `./mvnw spring-boot:run` (para Windows: `mvnw.cmd spring-boot:run`)

## Configuração

- Banco de dados e JavaMailSender: atualize o arquivo `application.properties` com as informações do seu banco de dados PostgreSQL e JavaMailSender.

## Uso

1. Ao iniciar o projeto, um usuário com a role de administrador é inserido no banco de dados automaticamente em `AdminDataLoader.java`. Suas informações podem ser alteradas tanto lá, quanto em `application.properties`.
2. Utilize um usuário com role de administrador para ter acesso aos endpoints protegidos.

## Endpoints

Author:

- `ADMIN Role` `POST /authors`: Salva um autor.
- `BASIC Role` `GET /authors/{id}`: Obtém um autor por id.
- `BASIC Role` `GET /authors`: Obtém todos autores.
- `ADMIN Role` `PUT /authors/{id}`: Atualiza um autor.
- `ADMIN Role` `DELETE /authors/{id}`: Deleta um autor.

Book:

- `ADMIN Role` `POST /books`: Salva um livro.
- `BASIC Role` `GET /books/{id}`: Obtém um livro por id.
- `BASIC Role` `GET /books`: Obtém todos livros.
- `ADMIN Role` `PUT /books/{id}`: Atualiza um livro.
- `ADMIN Role` `DELETE /books/{id}`: Deleta um livro.
- `BASIC Role` `GET /books/by-author/{authorId}`: Obtém todos os livros de um autor.
- `BASIC Role` `GET /books/by-category/{categoryId}`: Obtém todos os livros de uma categoria.
- `BASIC Role` `GET /books/best-rated`: Obtém os livros com melhores avaliações.
- `BASIC Role` `GET /books/most-borrowed`: Obtém os livros mais emprestados.

Category:

- `ADMIN Role` `POST /categories`: Salva uma categoria.
- `BASIC Role` `GET /categories/{id}`: Obtém uma categoria por id.
- `BASIC Role` `GET /categories`: Obtém todas categorias.
- `ADMIN Role` `PUT /categories/{id}`: Atualiza uma categoria.
- `ADMIN Role` `DELETE /categories/{id}`: Deleta uma categoria.

Loan:

- `BASIC Role` `POST /loans`: Salva um empréetimo.
- `BASIC Role` `GET /loans/{id}`: Obtém um empréetimo por id.
- `ADMIN Role` `GET /loans`: Obtém todos empréetimos.
- `BASIC Role` `PUT /loans/{id}`: Atualiza um empréetimo.
- `BASIC Role` `DELETE /loans/{id}`: Deleta um empréetimo.

Review:

- `BASIC Role` `POST /reviews`: Salva uma avaliação.
- `BASIC Role` `GET /reviews/{id}`: Obtém uma avaliação por id.
- `BASIC Role` `GET /reviews`: Obtém todas avaliações.
- `BASIC Role` `PUT /reviews/{id}`: Atualiza uma avaliação.
- `BASIC Role` `DELETE /reviews/{id}`: Deleta uma avaliação

User:

- `POST /register`: Registra um usuário e envia um email de confirmação.
- `GET /check/{userId}/{verificationId}`: Verifica se o id informado é igual ao id enviado ao email no registro do usuário.
- `ADMIN Role` `GET /users`: Obtém todos os usuários.
- `BASIC Role` `PUT /update-password`: Atualiza a senha de um usuário caso o email informado pertença a quem chamou..

Acesse a documentação completa no endpoint `/swagger-ui.html`

## Contribuições

Contribuições são muito bem vindas! Caso queira contribuir, faça um fork do repositório e crie um pull request.

## Contato

Caso tenha alguma sugestão ou dúvida, entre em contato comigo em [LinkedIn](https://www.linkedin.com/in/gabrieudev)

---

**Licença:** Esse projeto é licenciado sob os termos da [GNU General Public License (GPL)](LICENSE).
