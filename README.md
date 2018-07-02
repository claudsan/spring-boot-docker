# Micro Serviços com Spring Boot, Docker e MongoDB

Aqui é mostrado um serviço simples utilizando as tecnologias e frameworks citados acima.

## Pré Requisitos
- Maven
- Java
- Docker
- MongoDB

## Preparando ambiente

```
mvn clean package dockerfile:build 
```

## Executando

Executando o serviço

```
docker run -it -p 8080:8080 claudsan/claudsan-app
````

````
docker ps -a
CONTAINER ID        IMAGE                   COMMAND                  CREATED             STATUS                        PORTS                                                NAMES
31d0c481431c        claudsan/claudsan-app   "java -jar /claudsan…"   6 minutes ago       Up 6 minutes                  0.0.0.0:8080->8080/tcp                               flamboyant_lamport
````

## Acessando a documentação da API (Swagger)
- Ou o Json do Swagger [aqui](swagger-doc.json)
- Direto na aplicação em execução:
  [http://localhost:8080/swagger-ui.htm](http://localhost:8080/swagger-ui.htm)


---

<img src="http://netcoders.com.br/wp-content/uploads/2016/09/swagger-logo.png" width="150"/>  <img src="https://redash.io/assets/images/integrations/mongodb.png" width="150"/> <img src="https://mveeprojects.files.wordpress.com/2017/10/spring-boot-docker.png"  width="340"/>

