# version

Microservicio Spring Boot desarrollado como actividad de versionado con Git.

## Requisitos

- Java 17
- Maven (o usar el wrapper `./mvnw` incluido)

## Cómo ejecutar

```bash
./mvnw spring-boot:run
```

El servicio queda disponible en `http://localhost:8080`.

## Endpoints disponibles

Todos los endpoints están en `VersionController`.

### GET /api/saludo

Devuelve un saludo fijo.

**Respuesta:**
```json
{
  "mensaje": "Hola Mundo"
}
```

### GET /api/saludo/{nombre}

Devuelve un saludo personalizado.

**Ejemplo:** `GET /api/saludo/Francisco`

**Respuesta:**
```json
{
  "mensaje": "Hola, Francisco"
}
```

## Historial de versiones

- **1.0.0** — Creación del microservicio con endpoint `GET /api/saludo`.
- **1.1.0** — Nuevo endpoint `GET /api/saludo/{nombre}`.
- **1.1.1** — Corrección de bug: el saludo personalizado cortaba la última letra del nombre.
