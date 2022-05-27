<h1 align="center">Gerenciador De Estacionamentos</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
  <img src="https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white">
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white">
  <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=black">
</p>

  <p align="center">Projeto de uma API para gerenciar um estacionamento de carros e motos.</p>
  
  ## 🚀 Funcionalidades
  - [x] Cadastro de Estabelecimento (CRUD)
  - [x] Cadastro de Veículos (CRUD)
  - [x] Entrada e saída de veículos
  - [x] Geração de relatório para controle de entradas e saídas
  
  ## ⚙️ Pré-requisitos
  <p>  Antes de começar, é necessário que você tenha instalado na sua máquina as seguintes ferramentas: </p>
  
  - JDK (nesse projeto foi utilizada a 16, você pode baixar [aqui](https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html))
  - Uma IDE ou editor de código (para o desenvolvimento do projeto foi utilizado o IntelliJ, você pode baixar [aqui](https://www.jetbrains.com/idea/download/#section=windows))
  - PostgreSQL ([aqui](https://www.postgresql.org/download/))

### Instalação
1. Clone o repositório na sua máquina com `git clone https://github.com/gabrieladipoggio/gerenciador-estacionamentos.git`
2. No PostgreSQL, crie o banco de dados 'desafio', usuário e senha
3. Abra o projeto no editor de código de sua preferência
4. Entre no arquivo `application.properties` 
5. Altere as propriedades `spring.datasource.username` e `spring.datasource.password` para o nome de usuário e senha criados no passo anterior
6. O projeto está pronto para rodar! 

## 📄 Documentação
Para a documentação do projeto foi utilizado o Swagger. Com o projeto rodando na sua máquina, você pode acessá-lo [aqui](http://localhost:8080/swagger-ui.html#/).

## 🔍 Endpoints
O projeto conta com duas classes de Controllers, representando o Veículo (Vehicle) e a Empresa (Company). Dessa forma, foi desenvolvido o CRUD completo de cada uma dessas classes, bem como alguns métodos auxiliares, sendo eles:

1. __/company/report__: gera um arquivo .csv contendo uma listagem de todos os carros que passaram pelo estacionamento nas últimas 24 horas, além da contagem de quantos veículos estão estacionados no momento (especificando o número de carros e motos) e o número total de entradas e saídas do dia.
2. __/vehicle/addToGarage__: método responsável por adicionar um carro no estacionamento, com base no id do estabelecimento e placa do carro previamente cadastrado.
3. __vehicle/removeFromGarage__: metódo responsável por remover um carro do estacionamento, com base no id do estabelecimento e placa do carro previamente cadastrado.
4. __vehicle/search/{registration}__: método responsável por buscar um carro no banco de dados, com base na sua placa.
