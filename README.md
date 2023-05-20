# API de Aplicación de publicaciones
## Descripción
API de aplicación de publicaciones, desarrollada en Spring, que permite realizar las siguientes acciones:
- Registrar usuarios
- Modificar usuarios
- Eliminar usuarios
- Iniciar sesión
- Crear una publicación
- Listar las publicaciones
- Listar las publicaciones por usuario
- Eliminar una publicación
- Comentar una publicación
- Listar los comentarios de una publicación
- Eliminar un comentario
- Registrar un reporte
- Listar los reportes
- Eliminar un reporte

## Tecnologías
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

## Instalación
1. Clonar el repositorio
```
git clone
```
2. Configurar el archivo application.properties
```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/{DATABASE_NAME}?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=10MB
media.location=mediafiles
```
Las tablas de la base de datos se crea automáticamente al ejecutar el proyecto
3. Compilar y empaquetar el proyecto
```
mvn clean package
```
4. Ejecutar el proyecto
```
mvn spring-boot:run
```
5. Probar el proyecto
```
http://localhost:8080/
```
## Uso
### Usuarios
#### Registrar usuarios
```
POST /new/user
```
```
{
    "id": 1,
    "username": "juanb",
    "password": "123456",
    "email": "juan@email.com",
    "dateOfBirth": "17/02/1990",
    "sex": "m"
}
```
#### Editar un usuario
```
PUT /update/user?id={id}
```
```
    "username": "juanb",
    "password": "123456",
    "email": "juan@email.com",
    "dateOfBirth": "17/02/1990",
    "sex": "m"
```
#### Obtener un usuario por id
```
GET /get/user-by-id?id={id}
```
#### Eliminar un usuario
```
DELETE /delete/user?id={id}
```
#### Obtener lista de usuarios
```
GET /get/all-users
```
#### Iniciar sesión
```
POST /login
```
```
{
    "username": "juanb",
    "password": "123456"
}
```
### Publicaciones
#### Crear una publicación
```
POST /new/post
```
```
{
    "title": "Publicación 1",
    "body": "Descripción de la publicación 1",
    "image": "image.jpg",
    "date": "17/02/2021",
    "userOwner": {
        "id": 1
        "username": "juanb",
        "password": "123456",
        "email": "juan@email.com",
        "dateOfBirth": "17/02/1990",
        "sex": "m"
    }
}
```
#### Eliminar una publicación
```
DELETE /delete/post?id={id}
```
#### Obtener lista de publicaciones
```
GET /get/all-posts
```
#### Obtener lista de publicaciones por usuario
```
GET /get/all-posts-by-owner?id={id}
```
### Comentarios
#### Crear un comentario
```
POST /new/comment
```
```
{
    "text": "Comentario 1",
    "post": {
        "id": 1,
        "title": "Publicación 1",
        "body": "Descripción de la publicación 1",
        "image": "image.jpg",
        "date": "17/02/2021"
    }
    "user": {
        "id": 1
        "username": "juanb",
        "password": "123456",
        "email": "juan@email.com",
        "dateOfBirth": "17/02/1990",
        "sex": "m"
    }
}
```
#### Eliminar un comentario
```
DELETE /delete/comment?id={id}
```
#### Obtener lista de comentarios por publicación
```
GET /get/all-comments-by-post?id={id}
```
### Archivos
#### Subir un archivo
```
POST /upload
```
#### Obtener un archivo
```
GET /media/{filename}
```
### Reportes
#### Guardar un reporte
```
POST /save/report
```
```
{
    "id": 1,
    "type": "BUG",
    "comment": "Error al iniciar sesión"
```
#### Obtener lista de reportes
```
GET /get/all-reports
```
#### Eliminar un reporte
```
DELETE /delete/report?id={id}
```
### Última actualización
Mayo 2023