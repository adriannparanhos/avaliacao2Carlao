# API de Reparos Automotivos - CarRepair

API RESTful desenvolvida como parte de uma avaliação acadêmica para gerenciar consertos de veículos em uma oficina. O projeto utiliza uma abordagem de modelo de dados com entidade única e componentes embutidos, conforme solicitado.

---

## ✨ Funcionalidades

- CRUD completo para Consertos: Criação, listagem, busca por ID, atualização parcial e exclusão.
- Autenticação e Autorização: Sistema de login com JWT (JSON Web Token) para proteger os endpoints.
- Exclusão Lógica: Os registros não são apagados do banco, mas sim marcados como inativos (`ativo = false`).
- Banco de Dados Versionado: Utilização do Flyway para gerenciar a evolução do schema do banco de dados de forma automática.
- Validação de Dados: As requisições são validadas para garantir a integridade dos dados.

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot 3.2.2
- Spring Data JPA
- Spring Security (com autenticação JWT)
- Hibernate
- Flyway (para migrations)
- H2 Database (banco de dados em memória)
- Lombok

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java JDK 21 ou superior.
- Maven 3.8 ou superior.

### Passos
1.  **Clone o repositório:**
    ```bash
    git clone <url-do-seu-repositorio>
    ```
2.  **Navegue até a pasta do projeto:**
    ```bash
    cd <nome-da-pasta-do-projeto>
    ```
3.  **Execute o projeto com o Maven:**
    ```bash
    mvn spring-boot:run
    ```
4.  A API estará disponível em `http://localhost:8080`.

---

## 📚 Documentação da API

A seguir estão os endpoints disponíveis para interagir com a API.

### Autenticação
Todos os endpoints, exceto `/login`, são protegidos e exigem um token JWT.

#### **Realizar Login**
Para obter um token, envie uma requisição `POST` para o endpoint `/login`.

* **Endpoint:** `POST /login`
* **Corpo da Requisição:**
    ```json
    {
      "login": "pw3",
      "senha": "pw3"
    }
    ```
* **Resposta de Sucesso (`200 OK`):**
    ```json
    {
      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    }
    ```
* **Uso do Token:** O token retornado deve ser incluído no cabeçalho `Authorization` de todas as requisições subsequentes no formato `Bearer <token>`.

### Endpoints de Consertos
Todas as operações são realizadas através do endpoint base `/api/consertos`.

| Verbo | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/api/consertos` | Cria um novo registro de conserto. |
| `GET` | `/api/consertos` | Lista todos os consertos ativos de forma paginada. |
| `GET` | `/api/consertos/{id}` | Busca os dados de um único conserto pelo ID. |
| `PATCH` | `/api/consertos/{id}` | Atualiza parcialmente os dados de um conserto. |
| `DELETE`| `/api/consertos/{id}` | Realiza a exclusão lógica de um conserto (define `ativo=false`).|

### Detalhes dos Endpoints

#### `POST /api/consertos`
Cria um novo conserto com dados embutidos de mecânico e veículo.

* **Corpo da Requisição:**
    ```json
    {
      "dataEntrada": "11/06/2025",
      "dataSaida": null,
      "mecanico": {
        "nome": "Ricardo Mendes",
        "anos_experiencia": 12
      },
      "veiculo": {
        "marca": "Fiat",
        "modelo": "Toro",
        "ano": "2022",
        "cor": "Vinho"
      }
    }
    ```
