# Netdeal Integration Service

> Backend service responsible for integrating with the Netdeal platform, handling external API communication, data transformation, and business rule orchestration.

---

## 📌 Overview

This project is a technical implementation of an integration layer with the Netdeal ecosystem. It demonstrates how to structure a backend service that:

- Consumes external APIs reliably
- Transforms and normalizes payloads
- Encapsulates business logic independently of third-party systems
- Maintains separation of concerns for long-term maintainability

The focus is not just functionality, but **engineering quality, resilience, and evolvability**.

---

## 🧱 Architecture

The system follows a **layered architecture with clear separation of responsibilities**, designed to avoid tight coupling with external systems.

### High-level flow

```

Controller → Service → Integration Client → External API (Netdeal)
↓
Domain Model / DTO Mapping

```

---

## 🧭 C4 Model (Context View)

```

+-------------------+        HTTP/JSON        +----------------------+
|                   |  -------------------->  |                      |
|  Client / System  |                         |  Netdeal Platform     |
|                   |  <--------------------  |                      |
+-------------------+        Response         +----------------------+

```
       |
       | REST API
       v
```

+------------------------------------------------------+

| Netdeal Integration Service                              |
| -------------------------------------------------------- |
| - Request validation                                     |
| - Business rules                                         |
| - Payload transformation                                 |
| - External API orchestration                             |
| +------------------------------------------------------+ |

```

---

## 🧩 Components

### 1. Controller Layer
- Exposes REST endpoints
- Handles request validation
- Delegates processing to service layer

### 2. Service Layer
- Core business orchestration
- Applies transformation rules
- Coordinates integration calls

### 3. Integration Layer (Client)
- Encapsulates HTTP communication with Netdeal
- Isolated from business logic
- Responsible for retries / error mapping (if implemented)

### 4. Domain / DTO Layer
- Separates internal model from external API contracts
- Prevents coupling with Netdeal schema changes

---

## ⚙️ Tech Stack

- Java 11+ / 17 (depending on runtime)
- Spring Boot
- REST APIs (JSON over HTTP)
- Maven build system
- Jackson (serialization)
- SLF4J / Logback (logging)

---

## 🔌 External Integration (Netdeal)

The system integrates with Netdeal APIs to:

- Send structured business/event data
- Normalize internal payloads into external contract format
- Handle API responses and errors gracefully

### Integration principle

> External API models are never leaked into the domain layer.

Instead:
```

Domain Model → Mapper → DTO → Netdeal API

````

---

## 🧠 Design Decisions

### 1. Separation of concerns over "quick integration"
The integration client is isolated to avoid:
- business logic leaking into HTTP layer
- vendor lock-in in core domain

---

### 2. DTO isolation strategy
We explicitly separate:
- Internal domain models
- External API DTOs

This ensures:
- resilience to API changes
- safer refactoring
- cleaner test boundaries

---

### 3. Stateless service design
All services are stateless to allow:
- horizontal scalability
- easier testing
- safer concurrency

---

## ⚠️ Error Handling Strategy

- External API failures are handled at integration layer
- Service layer interprets and maps errors into domain-friendly responses
- Controller layer exposes consistent HTTP responses

Recommended improvements (if not implemented yet):
- Retry with exponential backoff
- Circuit breaker pattern (Resilience4j)

---

## 📊 Observability

Recommended production-ready additions:

- Structured logging (JSON logs)
- Correlation ID propagation
- Metrics (Micrometer + Prometheus)
- Distributed tracing (OpenTelemetry)

---

## 🧪 Testing Strategy

Current structure supports:

### Unit tests
- Service layer logic
- Mapping logic

### Integration tests
- API client mocking (WireMock recommended)

### Suggested stack
- JUnit 5
- Mockito
- Testcontainers (for future DB or external dependencies)

---

## 🚀 How to run

### Prerequisites
- Java 11+
- Maven 3+

### Run locally

```bash
git clone https://github.com/Will-thom/netdeal-teste.git
cd netdeal-teste

mvn clean install
mvn spring-boot:run
````

---

## 🔐 Configuration

Environment variables (if applicable):

```bash
NETDEAL_API_URL=
NETDEAL_API_KEY=
SERVER_PORT=
```

Recommended improvement:

* externalized config via Spring profiles (`application-dev.yml`, `application-prod.yml`)

---

## 📈 Trade-offs

### Chosen approach: Layered architecture

✔ Pros:

* simple to understand
* fast to implement
* good for small/mid systems

✖ Cons:

* can become rigid at scale
* risk of service layer "god objects"

---

### Why not Hexagonal / Clean Architecture (yet)?

For the current scope:

* overhead would be unnecessary
* layered model provides sufficient isolation

However, migration path is straightforward due to DTO isolation.

---

## 🧭 Future Improvements

If evolving this into a production-grade system:

### Architecture

* Move toward Hexagonal Architecture (Ports & Adapters)
* Introduce domain-driven boundaries

### Resilience

* Circuit breaker (Resilience4j)
* Retry policies with jitter
* Dead-letter handling (if async)

### Infrastructure

* Docker support
* CI/CD pipeline (GitHub Actions)
* Kubernetes deployment manifests

### Observability

* OpenTelemetry tracing
* Centralized logging (ELK / Loki)

---

## 🧠 Final Notes

This project prioritizes **clarity, separation of concerns and maintainability**, rather than over-engineering.

The design is intentionally incremental-friendly — allowing it to evolve into a more complex architecture without requiring a full rewrite.

---

## 📄 License

Educational / Technical assessment project.
