# ZagWork - Teste

Projeto de teste para empresa financeira.

### Objetivo
Desenvolver camada visual com AngularJS e um serviço para tratar das seguintes regras de negócio:

Criar um formulário com os seguintes campos:
- Nome Cliente (Tipo: texto)
- Limite de credito (Tipo: numérico (R$))
- Risco (Tipo: lista - Valores possíveis: A, B e C)

### Componentes e Tecnologias Utilizadas

- **test-fe**: HTML5, CSS3, Bootstrap 4 e AngularJS
- **test-api**: Java 8, Spring Boot, RestTemplate, Spring Actuator
- **test-user-microservice**: Java 8, Spring Boot, RestTemplate, GSON, JUnit, MockMVC, SwaggerIO 2, Spring Actuator
- **test-risk-microservice**: Java 8, Spring Boot, RestTemplate, GSON, JUnit, MockMVC, SwaggerIO 2, Spring Actuator
- **test-interest-microservice**: Java 8, Spring Boot, RestTemplate, GSON, JUnit, MockMVC, SwaggerIO 2, Spring Actuator

### Arquitetura Básica
A ideia é que o front seja totalmente independente das camadas de negócio, podendo ser substituido ou evoluído a qualquer momento.


O componente responsável pela orquestração entre os serviços é o **test-api**, em caso de falha de qualquer componente ele seria o responsável por trabalhar o melhor retorno para o front (foi implementado um health check de cada um dos serviços dependentes - em um fluxo de delivery contínuo, haveria um step do pipeline (teste integrado, por exemplo) para garantir que apenas com tudo no ar uma nova versão do componente seria entregue.


Todos os outros componentes possuem a mesma ideia básica, trabalhar com um escopo específico, pequeno e único. Apenas dois possuem persistência de dados (em memória, HSQLDB - mas pode ser facilmente alterado para um banco físico). Existe troca de informações entre eles (interest possui referencia ao id de user, e antes de persistir em seu banco, valida chamando o microservice responsável). De qualquer forma, as bases e os serviços em si são sempre independentes na manutenção e entrega.

![](https://i.ibb.co/Dfy6fMG/Arch.png)



### Como Rodar

Atenção: Todos os projetos tem como pré-requisito: Java 8 e Maven 3.5

Clone todos os projetos para uma pasta de sua escolha (Ex: \dev\git)

Inicie pelo build de todos dos microservices:

`$ mvn clean install -f \dev\git\test-user-microservice\pom.xml`

`$ mvn clean install -f \dev\git\test-risk-microservice\pom.xml`

`$ mvn clean install -f \dev\git\test-interest-microservice\pom.xml`

`$ mvn clean install -f \dev\git\test-api\pom.xml`

`$ mvn clean install -f \dev\git\test-fe\pom.xml`

                
----

Após o build e execução dos testes unitários, inicialize cada um dos componentes com seguintes comandos:

`$ mvn sprint-boot:run -f \dev\git\test-user-microservice\test-user-microservice-service\pom.xml`

`$ mvn sprint-boot:run -f \dev\git\test-risk-microservice\test-risk-microservice-service\pom.xml`

`$ mvn sprint-boot:run -f \dev\git\test-interest-microservice\test-interest-microservice-service\pom.xml`

`$ mvn sprint-boot:run -f \dev\git\test-api\pom.xml`

`$ mvn sprint-boot:run -f \dev\git\test-fe\pom.xml`



----


Para acessar a aplicação principal:
http://localhost:8080/home

Todas as chamadas são localhost (cada microserviço em uma porta) - para isso foi preciso habilitar o CrossOrigin em cada um deles. 

                
----

Se necessário algum teste específico em cada microservice via Swagger:

User: http://localhost:8082/documentation

Risk: http://localhost:8083/documentation

Interest: http://localhost:8084/documentation

                
----
Se necessário validar o status de cada microservice via Actuator:

User: http://localhost:8082/actuator/health

Risk: http://localhost:8083/actuator/health

Interest: http://localhost:8084/actuator/health

                
----


### Dúvidas
Luis Henrique Santos

lhsantos89@gmail.com

(11) 96607-3961
