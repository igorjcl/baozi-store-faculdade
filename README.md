# Baozi Store

API REST para gerenciamento de clientes, produtos e pedidos de uma loja.

## Tecnologias

- Java 17
- Spring Boot 4.0.6
- H2 (banco de dados em memória)
- Flyway (migrações)
- Lombok
- Gradle

## Pré-requisitos

- JDK 17+
- Gradle (ou usar o wrapper `./gradlew`)

## Setup

### 1. Clonar o repositório

```bash
git clone <url-do-repositorio>
cd baozi-store
```

### 2. Executar a aplicação

```bash
./gradlew bootRun
```

No Windows:

```bash
gradlew.bat bootRun
```

A aplicação sobe na porta `8080` por padrão.

### 3. Rodar os testes

```bash
./gradlew test
```

## Banco de dados

O projeto usa H2 em memória — nenhuma configuração extra necessária. O schema é criado automaticamente pelo Flyway ao iniciar.

Console do H2 disponível em: `http://localhost:8080/h2-console`

| Campo    | Valor              |
|----------|--------------------|
| JDBC URL | `jdbc:h2:mem:baozidb` |
| Username | `sa`               |
| Password | *(vazio)*          |

## Endpoints

| Recurso   | Base URL       |
|-----------|----------------|
| Clientes  | `/clientes`    |
| Produtos  | `/produtos`    |
| Pedidos   | `/pedidos`     |
