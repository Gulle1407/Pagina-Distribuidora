RESTful CRUD API construida con springboot, Spring Security y conectada a PostgreSQL usando JPA/Hibernate.Permite el manejo de productos de una base de datos.
El frontend consume la API usando ppeticiones fetch de JavaScript y recive respuestas en formato JSON.

RESTful CRUD API built with Spring Boot, secured with Spring Security, connected to PostgreSQL using JPA/Hibernate. Allows managing products from a database.
The frontend consumes the API using JavaScript fetch and receives JSON responses.


Instrucciones de ejecucion:
1. Clonar el repositorio
2. Crear base de datos en PostgreSQL
3. Configurar application.properties:

    spring.datasource.url=jdbc:postgresql://localhost:5432/BaseDeDatos
    spring.datasource.username=usuario
    spring.datasource.password=contraseña

4. Ejecutar en el directorio donde se encuentra el pom.xml:
   
    mvn spring-boot:run

La aplicacion corre en http://localhost:8080

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Mapstruct
- Maven


Usuario de prueba
Usuario: managerDistribuidora
Contraseña: MyCode0451
