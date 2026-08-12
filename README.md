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

### GET /api/status

Devuelve el estado del microservicio.

**Respuesta:**
```json
{
  "status": "UP",
  "service": "version",
  "message": "Microservicio funcionando correctamente"
}
```

### POST /api/calcular

Recibe dos números y una operación, y devuelve el resultado.

**Body de ejemplo:**
```json
{
  "operacion": "suma",
  "a": 10,
  "b": 5
}
```

Operaciones soportadas: `suma`, `resta`, `multiplicacion`, `division`.

**Respuesta:**
```json
{
  "operacion": "suma",
  "resultado": 15.0
}
```

Si `operacion` es `division` y `b` es 0, o si se envía una operación no soportada, el endpoint responde con un mensaje de error en vez de fallar.

## Historial de versiones

- **1.0.0** — Creación del microservicio con endpoint `GET /api/status`.
- **1.1.0** — Nuevo endpoint `POST /api/calcular`.
- **1.1.1** — Corrección de bug: división por cero y operaciones no soportadas ya no rompen el endpoint.
