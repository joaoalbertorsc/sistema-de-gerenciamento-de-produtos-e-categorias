# Sistema de Gerenciamento de Produtos e Categorias ☕

## 📝 Sobre o Projeto

Este repositório contém uma API RESTful de **Gerenciamento de Produtos e Categorias** desenvolvida em Java com o framework Spring Boot. O projeto tem como foco principal demonstrar a modelagem e manipulação de entidades que possuem relacionamentos entre si dentro de um banco de dados relacional.

O objetivo é servir como uma aplicação prática de como estruturar um sistema onde um produto pertence a uma categoria, e uma categoria pode possuir múltiplos produtos, garantindo a integridade referencial e evitando problemas comuns de serialização em APIs REST.

## 💡 Principais Conceitos Abordados

* **Relacionamento de Entidades (JPA/Hibernate):** Implementação prática de relacionamentos um-para-muitos (`@OneToMany`) e muitos-para-um (`@ManyToOne`), essenciais para modelar dados relacionais em aplicações Java.
* **Prevenção de Loops Infinitos:** Como utilizar padrões de design estratégicos nas anotações JPA para evitar o temido erro de serialização circular ao retornar entidades com relacionamentos em requisições HTTP.
* **Operações CRUD Completas:** Criação, leitura, atualização e deleção de Categorias e seus Produtos associados.
* **Arquitetura em Camadas:** Manutenção da separação de responsabilidades entre:
  - **Controladores** (camada de apresentação - exposição da API)
  - **Serviços** (camada de negócio - regras de negócio e lógica)
  - **Repositórios** (camada de persistência - acesso a dados)
* **Paginação e Busca Avançada:** Implementação de recursos de paginação e busca com ordenação para otimizar consultas em grandes volumes de dados.

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Descrição |
|-----------|-----------|
| **Java** | Versão 21 (LTS) |
| **Spring Boot** | v3.2.5 com Spring Web, Spring Data JPA |
| **Banco de Dados** | H2 (em memória - padrão) ou MySQL/PostgreSQL (customizável) |
| **Maven** | Gerenciador de dependências e build |
| **JPA/Hibernate** | Framework ORM para mapeamento objeto-relacional |

---

## 🚀 Como Executar o Projeto

Você pode rodar esta API de gerenciamento tanto diretamente pelo terminal quanto utilizando a sua IDE de preferência.

### 📋 Pré-requisitos

Certifique-se de ter instalado em sua máquina:

* **Java JDK** (versão 21) configurado nas variáveis de ambiente (`JAVA_HOME`).
* **Apache Maven** instalado (ou utilize o Maven Wrapper `./mvnw` incluso na raiz do repositório).

### 💻 Opção 1: Executando pelo Terminal (Sem IDE)

Para compilar o projeto e subir o servidor local rapidamente:

1. **Clone o repositório:**
```bash
git clone https://github.com/joaoalbertorsc/sistema-de-gerenciamento-de-produtos-e-categorias.git
cd sistema-de-gerenciamento-de-produtos-e-categorias
```

2. **Compile e baixe as dependências:**
Este comando faz o download das bibliotecas do Spring e compila o projeto:
```bash
mvn clean compile
```

3. **Execute a aplicação:**
Inicie a API utilizando o plugin do Spring Boot:
```bash
mvn spring-boot:run
```

4. **Verifique se está rodando:**
A aplicação estará disponível em `http://localhost:8080`

### 🖥️ Opção 2: Executando via IDE (IntelliJ IDEA, Eclipse, VS Code)

Para visualizar melhor o relacionamento das classes e depurar o comportamento do banco:

1. **Importar o Projeto:**
   - Abra a sua IDE.
   - Selecione a opção **Open** ou **Import Project**.
   - Escolha o arquivo `pom.xml` na raiz do diretório.
   - A IDE baixará e indexará as dependências automaticamente.

2. **Executar:**
   - Localize a classe principal `GerenciadorProdutosApplication.java` (possui a anotação `@SpringBootApplication`).
   - Clique com o botão direito sobre ela e selecione **Run** ou **Run Application**.

3. **Explorar o Banco de Dados (H2 Console):**
   - Caso o projeto esteja usando o banco em memória H2, você pode acessar a interface web do banco pelo navegador em:
   ```
   http://localhost:8080/h2-console
   ```
   - **JDBC URL:** `jdbc:h2:mem:testdb`
   - **User Name:** `sa`
   - **Password:** (deixe em branco)

---

## 📡 Endpoints da API

### **Categorias**

#### ✅ Criar Categoria
```http
POST /api/categorias
Content-Type: application/json

{
  "nome": "Eletrônicos",
  "descricao": "Produtos eletrônicos em geral"
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "nome": "Eletrônicos",
  "descricao": "Produtos eletrônicos em geral",
  "produtos": []
}
```

---

#### ✅ Obter Categoria por ID
```http
GET /api/categorias/{id}
```

**Exemplo:**
```http
GET /api/categorias/1
```

**Response (200 OK):**
```json
{
  "id": 1,
  "nome": "Eletrônicos",
  "descricao": "Produtos eletrônicos em geral",
  "produtos": [
    {
      "id": 1,
      "nome": "Notebook",
      "descricao": "Notebook para desenvolvimento",
      "preco": 3500.00,
      "categoria": {
        "id": 1,
        "nome": "Eletrônicos",
        "descricao": "Produtos eletrônicos em geral",
        "produtos": []
      }
    }
  ]
}
```

---

#### ❌ Deletar Categoria
```http
DELETE /api/categorias/{id}
```

**Exemplo:**
```http
DELETE /api/categorias/1
```

**Response (204 No Content):** (sem corpo de resposta)

---

### **Produtos**

#### ✅ Criar Produto
```http
POST /api/produtos
Content-Type: application/json

{
  "nome": "Notebook",
  "descricao": "Notebook para desenvolvimento",
  "preco": 3500.00,
  "categoria": {
    "id": 1
  }
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "nome": "Notebook",
  "descricao": "Notebook para desenvolvimento",
  "preco": 3500.00,
  "categoria": {
    "id": 1,
    "nome": "Eletrônicos",
    "descricao": "Produtos eletrônicos em geral",
    "produtos": []
  }
}
```

---

#### ✅ Obter Produto por ID
```http
GET /api/produtos/{id}
```

**Exemplo:**
```http
GET /api/produtos/1
```

**Response (200 OK):**
```json
{
  "id": 1,
  "nome": "Notebook",
  "descricao": "Notebook para desenvolvimento",
  "preco": 3500.00,
  "categoria": {
    "id": 1,
    "nome": "Eletrônicos",
    "descricao": "Produtos eletrônicos em geral",
    "produtos": []
  }
}
```

---

#### ✅ Listar Todos os Produtos (com Paginação)
```http
GET /api/produtos?page=0&size=10
```

**Response (200 OK):**
```json
{
  "content": [
    {
      "id": 1,
      "nome": "Notebook",
      "descricao": "Notebook para desenvolvimento",
      "preco": 3500.00,
      "categoria": {
        "id": 1,
        "nome": "Eletrônicos"
      }
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "empty": true,
      "sorted": false,
      "unsorted": true
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "totalElements": 1,
  "totalPages": 1,
  "last": true,
  "size": 10,
  "number": 0,
  "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
  },
  "numberOfElements": 1,
  "first": true,
  "empty": false
}
```

---

#### 🔍 Buscar Produtos por Nome (com Paginação e Ordenação)
```http
GET /api/produtos?nome=Notebook&page=0&size=10&direction=asc
```

**Parâmetros:**
| Parâmetro | Tipo | Descrição | Padrão |
|-----------|------|-----------|--------|
| `nome` | String | Parte do nome do produto a buscar (case-insensitive) | Não obrigatório |
| `page` | Integer | Número da página (começa em 0) | 0 |
| `size` | Integer | Quantidade de itens por página | 10 |
| `direction` | String | Direção de ordenação: `asc` ou `desc` | asc |

**Response (200 OK):** (mesmo formato da listagem)

---

#### ❌ Deletar Produto
```http
DELETE /api/produtos/{id}
```

**Exemplo:**
```http
DELETE /api/produtos/1
```

**Response (204 No Content):** (sem corpo de resposta)

---

## 🧪 Testando a API

### Usando Postman ou Insomnia

1. Abra o **Postman** ou **Insomnia**
2. Importe os exemplos de requisição fornecidos acima
3. Configure a URL base como `http://localhost:8080`
4. Teste os endpoints começando por criar uma categoria e depois produtos

### Usando cURL (Terminal)

**Criar uma categoria:**
```bash
curl -X POST http://localhost:8080/api/categorias \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Eletrônicos",
    "descricao": "Produtos eletrônicos em geral"
  }'
```

**Listar produtos com paginação:**
```bash
curl -X GET "http://localhost:8080/api/produtos?page=0&size=10"
```

**Buscar produtos por nome:**
```bash
curl -X GET "http://localhost:8080/api/produtos?nome=Notebook&page=0&size=10&direction=asc"
```

---

## 🗄️ Estrutura do Banco de Dados

### Tabela: `categoria`
| Coluna | Tipo | Constraints |
|--------|------|-------------|
| `id` | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| `nome` | VARCHAR(255) | NOT NULL |
| `descricao` | VARCHAR(255) | NULL |

### Tabela: `produto`
| Coluna | Tipo | Constraints |
|--------|------|-------------|
| `id` | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| `nome` | VARCHAR(255) | NOT NULL |
| `descricao` | VARCHAR(255) | NULL |
| `preco` | DECIMAL(19,2) | NOT NULL |
| `categoria_id` | BIGINT | FOREIGN KEY referencia `categoria(id)` |

---

## 📚 Estrutura do Projeto

```
src/
├── main/
│   └── java/org/ebac/gerenciadorProdutos/
│       ├── GerenciadorProdutosApplication.java    # Classe principal do Spring Boot
│       ├── controller/
│       │   ├── CategoriaController.java           # Endpoints de categorias
│       │   └── ProdutoController.java             # Endpoints de produtos
│       ├── service/
│       │   ├── CategoriaService.java              # Lógica de negócio de categorias
│       │   └── ProdutoService.java                # Lógica de negócio de produtos
│       ├── repository/
│       │   ├── CategoriaRepository.java           # Acesso a dados de categorias
│       │   └── ProdutoRepository.java             # Acesso a dados de produtos
│       └── entity/
│           ├── Categoria.java                     # Entidade Categoria (um-para-muitos)
│           └── Produto.java                       # Entidade Produto (muitos-para-um)
└── test/
    └── java/org/ebac/gerenciadorProdutos/
        └── GerenciadorProdutosApplicationTests.java
```

---

## 🔄 Relacionamentos Entre Entidades

### Diagrama Conceitual

```
┌──────────────┐                    ┌─────────────┐
│  CATEGORIA   │───────────┬────────│   PRODUTO   │
├──────────────┤           │        ├─────────────┤
│ id (PK)      │           │        │ id (PK)     │
│ nome         │        1:N│        │ nome        │
│ descricao    │           │        │ descricao   │
└──────────────┘           │        │ preco       │
                           │        │ categoria_id│ (FK)
                           └────────└─────────────┘
```

### Detalhes de Implementação

**Em `Categoria.java`:**
```java
@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Produto> produtos = new ArrayList<>();
```
- `mappedBy = "categoria"`: Indica que o relacionamento é bidirecional e definido no lado "muitos" da relação
- `cascade = CascadeType.ALL`: Quando uma categoria é deletada, todos os seus produtos também são deletados
- `orphanRemoval = true`: Remove produtos órfãos (produtos sem categoria associada)

**Em `Produto.java`:**
```java
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "categoria_id")
private Categoria categoria;
```
- `fetch = FetchType.LAZY`: Carrega a categoria apenas quando necessário (melhor desempenho)
- `@JoinColumn`: Define a coluna de chave estrangeira no banco de dados

---

## ⚠️ Observações Importantes

### Serialização e Loops Infinitos
Quando você recupera uma Categoria com seus Produtos, note que o relacionamento bidirecional é bem gerenciado pelo Spring:
- A Categoria retorna uma lista de Produtos
- Cada Produto retorna sua Categoria (sem recursão infinita)

Isso é possível porque o Spring Data JPA gerencia inteligentemente a serialização JSON, evitando loops circulares.

### Uso do H2 Console
Para development e testes locais, o projeto está configurado com H2. Se desejar usar MySQL ou PostgreSQL em produção:

1. Adicione a dependência no `pom.xml`:
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

2. Configure o `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

---

## 📖 Recursos Adicionais

- [Documentação Official Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA Guide](https://spring.io/projects/spring-data-jpa)
- [JPA Relationships](https://www.baeldung.com/jpa-one-to-many)
- [REST Best Practices](https://restfulapi.net/)

---

## 👨‍💻 Autor

**João Alberto** – Engenheiro de Software

---

## 📄 Licença

Este projeto é de código aberto e está disponível para fins educacionais e comerciais.

---

*Se este projeto te ajudou a entender como modelar e relacionar entidades no ecossistema Spring Boot, sinta-se à vontade para deixar uma ⭐ no repositório!*
