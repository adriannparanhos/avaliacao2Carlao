# 🛠 Tecnologias
- Java 21

- Spring Boot 3.2.2

- Spring Data JPA (Hibernate ORM 6.4.1)

- H2 (banco em memória)

- Flyway (migrations)

- Jakarta Validation

- Lombok 

# Maven

### 🚀 Como rodar
- Clone o repositório

- bash
- Copiar
- Editar
- git clone https://seu-repo.git
- cd project
- Build e run

- bash
- Copiar
- Editar
- mvn clean install
- mvn spring-boot:run
- A aplicação ficará disponível em http://localhost:8080.

- (Opcional) Acesse o H2 Console

- URL: http://localhost:8080/h2-console

- JDBC URL: jdbc:h2:mem:pw3api

- User: SA

- Password: (vazio)

### 🗂 Endpoints
## Mecânicos
##### **Método	URL	Descrição**
| Verbo   |                 URL                  |                      Ação |
|---------|:------------------------------------:|--------------------------:|
| GET     |           	 /api/mecanicos           |  Lista todos os mecânicos |
| GET	    |         /api/mecanicos/{id}	         |Busca por ID|
| POST	   | /api/mecanicos |Cria um novo mecânico |
| PUT     |	/api/mecanicos/{id} |	Atualiza um mecânico |
| DELETE	 |/api/mecanicos/{id}	|Remove um mecânico|

## Veículos

| Verbo  | URL                  | Ação                    |
| ------ | :--------------------: | -----------------------: |
| GET    | `/api/veiculos`      | Lista todos os veículos |
| GET    | `/api/veiculos/{id}` | Busca por ID            |
| POST   | `/api/veiculos`      | Cria um novo veículo    |
| PUT    | `/api/veiculos/{id}` | Atualiza um veículo     |
| DELETE | `/api/veiculos/{id}` | Remove um veículo       |

## Consertos

| Verbo | URL                      | Ação                                        |
| ----- | ------------------------ | ------------------------------------------- |
| POST  | `/api/consertos`         | Cria um novo conserto (passando apenas IDs) |
| GET   | `/api/consertos`         | Lista paginada de todos os consertos        |
| GET   | `/api/consertos/sumario` | Lista resumo de consertos (DTO resumido)    |


