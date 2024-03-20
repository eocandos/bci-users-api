# API Gestion de Usuarios

API creada con Java / Maven / Spring Boot

## Diagrama General
![diagrama-secuencia-users-api](https://github.com/eocandos/bci-users-api/assets/5439093/817d1086-f343-4ccb-8afc-ae6bb1e4565a)

## Como Ejecutarla

La aplicación es empaquetada como un jar con un Tomcat embebido. Por ende no es necesario instalar tomcat.

### Pasos

* Clonar repositorio
* Asegurarse de usar JDK 1.8 and Maven 3.x
* Crear proyecto con ```mvn clean package```
* Una vez construido el jar es posible correr la aplicación empleando alguno de los siguientes metodos:
```
        java -jar cl.com.users-api-1.0.0.jar
or
        mvn spring-boot:run"
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

http://localhost:8080/

