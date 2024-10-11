# Arquitecturas Web Tp3 SpringBoot-2024

## Proyecto de Registro de Estudiantes

Este proyecto consiste en la creación de una API REST utilizando Spring Boot y JPA para gestionar un registro de estudiantes. La aplicación permite realizar diversas operaciones como dar de alta estudiantes, matricularlos en carreras, consultar la información de los estudiantes y generar reportes sobre inscriptos y egresados por carrera, los mismos metodos que en la version previa a este se utilizaba JPA pero haciendo consultas por medio de querys JPQL y no utilizando la potencia que esta tecnologia ofrece.

### Tecnologías utilizadas
**Spring Boot:** Framework para la construcción de aplicaciones Java basadas en microservicios.
JPA (Java Persistence API): Para el mapeo objeto-relacional y la persistencia de datos en la base de datos.

**Postman:** Herramienta utilizada para probar los endpoints de la API.


## Estructura del proyecto

La estructura del proyecto está organizada de la siguiente manera:

## Introducción
Este trabajo práctico tiene como objetivo implementar un sistema de registro de estudiantes con las siguientes características:

- Dar de alta estudiantes con su información personal y académica.
- Matricular estudiantes en diversas carreras.
- Recuperar información detallada sobre estudiantes, carreras y generar reportes.

Utilizando Spring Boot como el framework base para la creación de la API, junto con JPA para la persistencia de los datos es posible realizar los objetivos nombrados anteriormente.

Se han implementado servicios, controladores y repositorios que se comunican para ofrecer las funcionalidades de la API.

### Funcionamiento de Spring Boot
El flujo general de la aplicación sigue el patrón de diseño MVC (Model-View-Controller).

- Los controladores reciben las solicitudes HTTP y actúan como intermediarios entre la capa de presentación y la lógica de negocio.
- Los servicios contienen la lógica de negocio, y son los responsables de procesar las solicitudes y comunicarse con la capa de persistencia.
- Los repositorios actúan como interfaces entre la aplicación y la base de datos, facilitando el acceso a las entidades JPA.

## Configuración y utilización de la API
//mostrar como ejecutar
//levantar docker
//correr springboot en el lugar que se diga
//informar sobre que existen datos previos cargados


### Endpoints:

1. Dar de alta un estudiante

Este endpoint permite registrar un nuevo estudiante en el sistema.

    Método HTTP: POST
    URL: /students
    Body (JSON)
    
```json
{
  "dni": 41385214,
  "idLibreta": 25431,
  "name": "Mariano",
  "lastName": "Pallero",
  "years": 40,
  "gender": "M",
  "city":{"id":1}
}
```
    Cuerpo respuesta OK 200
```json
{
    "dni": 41385214,
    "id_libreta": 25431,
    "name": "Mariano",
    "lastName": "Pallero",
    "years": 40,
    "gender": "M",
    "city": "Tandil"
}
```
Ante falta de campos o incorrecta solicitud
    
    Cuerpo respuesta BAD REQUEST 400
```json
{
    "message": "Faltan completar campos"
}
```

2. matricular un estudiante en una carrera

    