# foro-hub
API REST para una plataforma de foro (Foro Hub) desarrollada con Spring Boot. Implementa un CRUD completo para la gestión de tópicos, validaciones de reglas de negocio, persistencia en base de datos MySQL y seguridad mediante autenticación con JWT
# ForoHub - Challenge Oracle Next Education + Alura Latam

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-latest-blue)

## 📌 Sobre el Proyecto
ForoHub es una API REST diseñada para replicar el funcionamiento de un foro. Permite gestionar tópicos (preguntas o discusiones) siguiendo las mejores prácticas de desarrollo, incluyendo validaciones de negocio y persistencia en base de datos.

## 🚀 Funcionalidades (CRUD Completo)
He implementado los siguientes endpoints para la gestión de tópicos:

1. **Registrar Tópico** (`POST /topicos`): Crea un nuevo tópico validando que no existan duplicados (mismo título y mensaje).
2. **Listado de Tópicos** (`GET /topicos`): Muestra todos los tópicos almacenados.
3. **Detalle de Tópico** (`GET /topicos/{id}`): Muestra la información completa de un tópico específico.
4. **Actualización** (`PUT /topicos/{id}`): Permite modificar título y mensaje, verificando la existencia del ID.
5. **Eliminación** (`DELETE /topicos/{id}`): Borra de forma definitiva un tópico de la base de datos.

### ✨ Mejoras de Valor Añadido
A diferencia del requerimiento base, he enriquecido la entidad con:
* **Categoría**: Clasificación temática del tópico.
* **Prioridad**: Nivel de urgencia o importancia.
* **Etiquetas**: Para facilitar búsquedas futuras.

## 🛠️ Tecnologías Utilizadas
* **Java 17** (Uso de Records para DTOs)
* **Spring Boot 3** (Spring Data JPA, Spring Web)
* **PostgreSQL** (Base de datos relacional)
* **Flyway** (Migraciones de base de datos)
* **Insomnia** (Pruebas de API)

## 🚦 Requisitos para ejecutar
1. Clonar el repositorio.
2. Configurar las variables de entorno para la base de datos PostgreSQL en `application.properties`.
3. Ejecutar `mvn spring-boot:run`.