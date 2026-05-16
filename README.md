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

Endpoints principales

Grupo Service
* POST /grupos
* GET /grupos
* GET /grupos/{id}
* DELETE /grupos/{id}
  
Evento Service
* POST /eventos
* GET /eventos
* GET /eventos/{id}
* GET /eventos/grupo/{grupoId}
* DELETE /eventos/{id}
  
 Gasto Service
* POST /gastos
* GET /gastos
* GET /gastos/evento/{eventoId}
* DELETE /gastos/{id}

Ejemplo de prueba (Postman)
### Crear grupo

json
{
  "nombre": "Grupo prueba",
  "creadoPor": "usuario1"
}


### Crear evento

json
{
  "grupoId": "ID_DEL_GRUPO",
  "nombre": "Evento prueba",
  "descripcion": "test",
  "fechaEvento": "2026-05-15",
  "estado": "ACTIVO"
}

