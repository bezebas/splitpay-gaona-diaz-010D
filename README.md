---
SplitPay – Microservicios

Descripción del proyecto
Sistema de microservicios para la gestión de grupos, eventos y gastos de un sistema tipo SplitPay, donde los usuarios pueden crear grupos, asignar eventos y registrar gastos asociados.
El sistema está basado en arquitectura de microservicios con comunicación entre servicios usando *OpenFeign* y control de rutas mediante *API Gateway*.

---

Arquitectura del sistema

El sistema está compuesto por los siguientes microservicios:

* Usuario Service (puerto 8067)
* Grupo Service (puerto 8068)
* Evento Service (puerto 8082)
* Gasto Service (puerto 8070)
* Balance Service (puerto 8071)
* API Gateway (puerto 8083)
  
Comunicación entre microservicios:
* Evento Service valida la existencia de un grupo mediante OpenFeign hacia Grupo Service.
* Gasto Service valida la existencia de un evento mediante OpenFeign hacia Evento Service.

Puertos
*Usuarios 8067
*Grupos 8068
*Gastos 8070
*Balance 8071
*Eventos 8082

API Gateway
Puerto: 8083

Rutas principales
* /grupos/** → Grupo Service
* /eventos/** → Evento Service
* /gastos/** → Gasto Service
* /usuarios/** → Usuario Service
* /balance/** → Balance Service

Tecnologías utilizadas
* Java 21
* Spring Boot
* Spring Data JPA
* Spring Cloud OpenFeign
* Spring Cloud Gateway
* MySQL
* Maven
* Postman

Base de datos
Cada microservicio utiliza su propia base de datos independiente.
* bd_splitpay_usuarios
* bd_splitpay_grupos
* bd_splitpay_gastos
* bd_splitpay_balances
* bd_splitpay_eventos

Endpoints 

*http://localhost:8083/

Ejemplo de prueba (Postman)

http://localhost:8083/usuarios

POST

{
  "nombre": "Juan Pérez",
  "correo": "juan@email.com",
  "contrasenaHash": "123456"
} 

RESPUESTA

{
    "id": "233d1534-fd1b-4462-884b-1a64cb083351",
    "nombre": "Juan Pérez",
    "correo": "juan@email.com",
    "contrasenaHash": "123456",
    "puntajeReputacion": 0.0,
    "creado_en": "2026-05-15T22:02:36.8305614",
    "activo": true
}

******************************************************
http://localhost:8083/grupos

POST

{
  "nombre": "Grupo Universidad",
  "descripcion": "Trabajo de microservicios",
  "creadoPor": "a1b2c3d4-usuario"
}

RESPUESTA

{
    "id": "6cf8337d-6ddc-4741-b26e-de0cadff8fec",
    "nombre": "Grupo Universidad",
    "descripcion": "Trabajo de microservicios",
    "creadoPor": "a1b2c3d4-usuario",
    "creadoEn": "2026-05-15T22:05:27.9993514",
    "activo": true
}

******************************************************
http://localhost:8083/eventos

POST

{
  "grupoId": "6cf8337d-6ddc-4741-b26e-de0cadff8fec",
  "nombre": "Pizza Night",
  "descripcion": "Cena de equipo",
  "fechaEvento": "2026-05-15",
  "estado": "ACTIVO"
}

RESPUESTA

{
    "id": "971b7ccd-403f-4152-af56-fc20f78eb3de",
    "grupoId": "6cf8337d-6ddc-4741-b26e-de0cadff8fec",
    "nombre": "Pizza Night",
    "descripcion": "Cena de equipo",
    "fechaEvento": "2026-05-15",
    "estado": "ACTIVO"
}

SI GRUPO NO EXISTE

{
  "status": 404,
  "error": "El grupo no existe",
  "path": "/eventos"
}

******************************************************
http://localhost:8083/gastos

POST

{
  "eventoId": "971b7ccd-403f-4152-af56-fc20f78eb3de",
  "monto": 15000,
  "descripcion": "Pizza y bebidas",
  "pagadoPor": "Juan",
  "categoria": "Comida",
  "montoTotal": 25000,
  "tipoDivision": "Equitativo"
}


RESPUESTA

{
    "id": "14819e0f-3517-42c6-a130-6c6c4c4bdabd",
    "eventoId": "971b7ccd-403f-4152-af56-fc20f78eb3de",
    "pagadoPor": "Juan",
    "descripcion": "Pizza y bebidas",
    "categoria": "Comida",
    "montoTotal": 25000.0,
    "tipoDivision": "Equitativo"
}

SI EVENTO NO EXISTE

{
  "status": 404,
  "error": "El evento no existe",
  "path": "/gastos"
}

******************************************************
http://localhost:8083/balances

POST

{
  "id": "uuid-generado",
  "eventoId": "e1b7ccd-403f-4152-af56-fc20f78eb3de",
  "usuarioDeudorId": "233d1534-fd1b-4462-884b-1a64cb083351",
  "usuarioAcreedorId": "u2",
  "monto": 25000,
  "estado": "PENDIENTE"
}

RESPUESTA

{
    "id": dd4ff786-4dfd-4b08-a8d1-613f14691c0f,
    "eventoId": "e1b7ccd-403f-4152-af56-fc20f78eb3de",
    "usuarioDeudorId": "233d1534-fd1b-4462-884b-1a64cb083351",
    "usuarioAcreedorId": "u2",
    "monto": 25000.0,
    "estado": "PENDIENTE"
}



# SplitPay - Sistema de Microservicios

Este proyecto consiste en el desarrollo del ecosistema de microservicios para la plataforma SplitPay, diseñado para gestionar de forma eficiente cuentas compartidas, historiales, reputación de usuarios y autenticación segura mediante arquitectura distribuida con Spring Boot.

---

## Bibliotecas y Dependencias Utilizadas

El backend está construido utilizando el framework de Spring Boot 3.x, incorporando las siguientes librerías core distribuidas en los archivos pom.xml:

1. Spring Web: Para la exposición y manejo de APIs RESTful y controladores.
2. Spring Data JPA: Abstracción de persistencia de datos para interactuar de forma relacional con MySQL mediante Hibernate.
3. MySQL Driver: Conector nativo de Java para la comunicación con la base de datos MySQL.
4. Spring Security: Framework encargado de proteger las rutas y configurar una política de sesión sin estado (Stateless).
5. JJWT (Java JWT): Compuesto por jjwt-api, jjwt-impl y jjwt-jackson para la generación, firma digital y descifrado de tokens de acceso seguro.
6. Springdoc OpenAPI UI (Swagger): Generación automática de especificaciones y documentación interactiva de la API en tiempo de ejecución.
7. Lombok: Para reducir el código boilerplate (Getters, Setters, Contructores) mediante anotaciones.
8. JUnit 5 & Mockito (Spring Boot Starter Test): Herramientas estándar para el desarrollo de pruebas unitarias y mocks de comportamiento, alcanzando más del 60% de cobertura.

---

## Ejemplos de Rutas para Ejecución de API REST

### 1. Microservicio de Autenticación (auth-service) - Puerto 8085
* POST `/api/auth/login` -> Solicita el Token de acceso JWT.
    * Body (JSON):
        ```json
        {
          "username": "admin",
          "password": "duoc2026"
        }
        ```
    * Respuesta Exitosa (200 OK):
        ```json
        {
          "token": "eyJhbGciOiJIUzI1NiJ9...",
          "type": "Bearer"
        }
        ```

### 2. Microservicio de Reputación (db_reputacion) - Puerto 8090
* POST `/api/reputacion` -> Registra una nueva reputación.
    * Body (JSON):
        ```json
        {
          "usuarioId": "usr-test-100",
          "puntaje": 95,
          "nivel": "EXCELENTE",
          "observaciones": "Usuario paga sus cuotas a tiempo."
        }
        ```
* GET `/api/reputacion` -> Retorna el listado completo de reputaciones.
* GET `/api/reputacion/{id}` -> Retorna el registro de reputación por su ID único.
* GET `/api/reputacion/usuario/{usuarioId}` -> Retorna la reputación buscando por ID de usuario.
* PUT `/api/reputacion/{id}` -> Modifica puntaje, nivel u observaciones de un registro existente.
* DELETE `/api/reputacion/{id}` -> Elimina un perfil de reputación de la base de datos.

---

## Ejemplos de Ruta para Ejecución de Swagger

Cada microservicio expone de manera independiente su documentación gráfica interactiva a través de OpenAPI. Para visualizar los endpoints, interactuar con ellos y ejecutar pruebas en tiempo real, abre tu navegador web e ingresa a las siguientes direcciones de acuerdo al servicio que desees auditar:

* Swagger de Autenticación: `http://localhost:8085/swagger-ui/index.html`
* Swagger de Reputación: `http://localhost:8090/swagger-ui/index.html`
* Swagger de Historial: `http://localhost:8089/swagger-ui/index.html`

*(Nota: Asegúrate de que el microservicio correspondiente se encuentre en estado "Running" antes de ingresar a la URL).*




