# Sistema de Gerenciamento de Produtos e Categorias ☕

## 📝 Sobre o Projeto

Este repositório contém uma API RESTful de **Gerenciamento de Produtos e Categorias** desenvolvida em Java com o framework Spring Boot. O projeto tem como foco principal demonstrar a modelagem e manipulação de entidades que possuem relacionamentos entre si dentro de um banco de dados relacional.

O objetivo é servir como uma aplicação prática de como estruturar um sistema onde um produto pertence a uma categoria, e uma categoria pode possuir múltiplos produtos, garantindo a integridade dos dados e expondo essas operações através de endpoints HTTP seguros e bem estruturados.

## 💡 Principais Conceitos Abordados

* **Relacionamento de Entidades (JPA/Hibernate):** Implementação prática de relacionamentos um-para-muitos e muitos-para-um utilizando as anotações `@OneToMany` e `@ManyToOne`, essenciais para espelhar a estrutura do banco de dados relacional no código Java.
* **Prevenção de Loops Infinitos:** Como utilizar Padrões DTO (Data Transfer Object) ou anotações como `@JsonIgnore` / `@JsonManagedReference` para evitar o temido erro de serialização circular ao retornar entidades relacionadas no formato JSON.
* **Operações CRUD Completas:** Criação, leitura, atualização e deleção simultânea ou independente de Categorias e seus Produtos atrelados.
* **Arquitetura em Camadas:** Manutenção da separação de responsabilidades entre Controladores (exposição da API), Serviços (regras de negócio) e Repositórios (acesso a dados).

## 🛠️ Tecnologias Utilizadas

* Java (versão 17 ou superior recomendada)
* Spring Boot (Spring Web, Spring Data JPA, Validation)
* Banco de Dados (H2 em memória ou MySQL/PostgreSQL)
* Maven (gerenciador de dependências e build)

---

## 🚀 Como Executar o Projeto

Você pode rodar esta API de gerenciamento tanto diretamente pelo terminal quanto utilizando a sua IDE de preferência.

### 📋 Pré-requisitos

Certifique-se de ter instalado em sua máquina:

* **Java JDK** (versão 17 ou superior) configurado nas variáveis de ambiente (`JAVA_HOME`).
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


4. **Teste as Rotas:**
Com o servidor rodando (por padrão na porta `8080`), utilize o **Postman** ou **Insomnia** para realizar requisições `POST` e `GET` nos endpoints de categorias (ex: `http://localhost:8080/categorias`) e produtos (ex: `http://localhost:8080/produtos`), observando como os dados se relacionam nas respostas.

### 🖥️ Opção 2: Executando via IDE (IntelliJ IDEA, Eclipse, VS Code)

Para visualizar melhor o relacionamento das classes e depurar o comportamento do banco:

1. **Importar o Projeto:**
* Abra a sua IDE.
* Selecione a opção **Open** ou **Import Project**.
* Escolha o arquivo `pom.xml` na raiz do diretório. A IDE baixará e indexará as dependências automaticamente.


2. **Executar:**
* Localize a classe principal que possui a anotação `@SpringBootApplication`.
* Clique com o botão direito sobre ela e selecione **Run**.


3. **Explorar o Banco de Dados (H2 Console):**
* Caso o projeto esteja configurado com o banco em memória H2, você pode acessar a interface web do banco pelo navegador (geralmente em `http://localhost:8080/h2-console`) para visualizar fisicamente as chaves estrangeiras (Foreign Keys) criadas automaticamente pelo Hibernate.



---

## 👨‍💻 Autor

**João Alberto** – Engenheiro de Software

---

*Se este projeto te ajudou a entender como modelar e relacionar entidades no ecossistema Spring Boot, sinta-se à vontade para deixar uma ⭐ no repositório!*
