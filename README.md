# API Gestion de Usuarios

## Tecnologías
* Java 8
* Spring Boot 2.5.4
* Maven 3x
* JPA
* H2
* JWT

## Diagrama de Secuencia
![diagrama-secuencia](https://github.com/eocandos/bci-users-api/assets/5439093/831e4f9f-5229-4c1e-b1b5-ee8433a9167f)

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
#### Se crea con los datos: correo, contraseña, nombre, telefonos y rol
![new-user](https://github.com/eocandos/bci-users-api/assets/5439093/998b04f7-b1f5-454c-93b2-9f3bc8dda2d5)

### Intento acceso No Autorizado
#### Usuario que no está registrado
![unauthorized](https://github.com/bezkoder/spring-boot-spring-security-jwt-authentication/assets/5439093/ac2129dc-327e-4454-bef8-84699edb0f18)

### Acceso Exitoso
#### Se ingresa correo y contraseña registrados previamente
![login-successfull](https://github.com/eocandos/bci-users-api/assets/5439093/6bfc9dab-f331-494d-92a5-7a0683d72456)

### Obtener todos los usuarios registrados 
#### Usuario registrado, se usa token generado para poder consultar la lista de usuarios almacenados
![get-all-users](https://github.com/eocandos/bci-users-api/assets/5439093/3eb1f579-c0cf-4050-98c1-9542f3d0c773)

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
![postman-requests](https://github.com/eocandos/bci-users-api/assets/5439093/ae329ded-37ef-493a-875b-7d42fd17f980)


#### Vista Swagger
![swagger-contrato](https://github.com/eocandos/bci-users-api/assets/5439093/39164598-8f0f-4187-9f57-40667edc36f1)