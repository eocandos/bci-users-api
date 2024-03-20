# API Gestion de Usuarios

## Tecnologías
* Java 8
* Spring Boot 2.5.4
* Maven 3x
* JPA
* H2
* JWT

## Diagrama de Secuencia
![diagrama-secuencia](https://github.com/bezkoder/spring-boot-spring-security-jwt-authentication/assets/5439093/1455d06e-80bb-4e25-9496-530daf9e07ce)

## Como Ejecutarla

La aplicación es empaquetada como un jar con un Tomcat embebido. Por ende no es necesario instalar tomcat.

### Pasos

* Clonar repositorio
* Asegurarse de usar JDK 1.8 and Maven 3.x
* Crear proyecto con ```mvn clean package```
* Una vez construido el jar es posible correr la aplicación empleando alguno de los siguientes metodos:
```
        java -jar users-api-1.0.0.jar
o
        mvn spring-boot:run
```
Una vez ejecutada debería aparecer algo como esto en la consola:

```
2024-03-20 06:05:32.761  INFO 23496 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2024-03-20 06:05:32.763  INFO 23496 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
2024-03-20 06:05:32.785  INFO 23496 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 1 custom documentation plugin(s)
2024-03-20 06:05:32.821  INFO 23496 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2024-03-20 06:05:32.997  INFO 23496 --- [           main] cl.com.users.api.UsersApi                : Started UsersApi in 7.07 seconds (JVM running for 7.589)```
```

## Acceso y Pruebas

### Enpoints 
##### * Servicios *
```
http://localhost:8080/api
```
##### * Base de Datos H2 *
```
http://localhost:8080/h2-console
```
##### * Swagger (Contrato autogenerado)* 
```
http://localhost:8080/swagger-ui.html#/
```

### Registro Nuevo Usuario
![new-user-ok](https://github.com/bezkoder/spring-boot-spring-security-jwt-authentication/assets/5439093/0ef16f59-17ca-43b9-a50a-f60c69c05a45)

### Intento acceso No Autorizado
![unauthorized](https://github.com/bezkoder/spring-boot-spring-security-jwt-authentication/assets/5439093/ac2129dc-327e-4454-bef8-84699edb0f18)

### Acceso Exitoso
![login-ok-token](https://github.com/bezkoder/spring-boot-spring-security-jwt-authentication/assets/5439093/4c2a7634-7bd8-43f8-978d-89694d15e264)

### Acceso a la Base de Datos H2 
#### (Credenciales en archivo application.yml)

![db-h2-1](https://github.com/bezkoder/spring-boot-spring-security-jwt-authentication/assets/5439093/083384c7-bd83-4f53-b753-d4e62aa6683a)

#### Consulta de Usuarios creados
![db-h2-2](https://github.com/bezkoder/spring-boot-spring-security-jwt-authentication/assets/5439093/77228cd8-a760-4f4b-924b-d08488e9bb8b)

#### Consulta de telefonos guardados
![db-h2-3](https://github.com/bezkoder/spring-boot-spring-security-jwt-authentication/assets/5439093/7361f33f-7add-417c-942f-41669456e949)

#### Colección postman para pruebas
```
../resources/BCI USERS APP.postman_collection.json
```

#### Vista Swagger
![swagger-contrato](https://github.com/eocandos/bci-users-api/assets/5439093/39164598-8f0f-4187-9f57-40667edc36f1)