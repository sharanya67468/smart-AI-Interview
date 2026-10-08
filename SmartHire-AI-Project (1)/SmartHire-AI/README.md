# SmartHire AI – AI-Powered Interview Preparation & Evaluation System

A real-world, interview-oriented full-stack project for Computer Science students.

## Problem
Students often practice interviews without structured feedback. SmartHire AI provides simulated technical/HR interviews, coding practice, AI-assisted feedback, scoring, and performance history.

## Stack
- Frontend: HTML5, CSS3, JavaScript
- Backend: Java 17, Spring Boot 3
- Database: H2 by default (easy demo); MySQL configuration included
- AI: Provider-agnostic service with a safe mock mode. Add an AI API key later to connect a real provider.

## Features
- Dashboard
- Interview session creation
- Technical/HR question bank
- Answer submission
- AI-style evaluation and feedback
- Coding practice endpoint
- Performance history
- REST API
- CORS configuration
- Layered Spring Boot architecture

## Run
### Backend
Requirements: Java 17+, Maven 3.9+

```bash
cd backend
mvn spring-boot:run
```

Backend: http://localhost:8080

### Frontend
Open `frontend/index.html` with a local server. For example, from the project root:

```bash
python -m http.server 5500 -d frontend
```

Open http://localhost:5500

## Database
The default profile uses H2 in-memory database, so the project runs without installing MySQL.
H2 console: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:smarthire
- User: sa
- Password: (empty)

To use MySQL, create a database named `smarthire`, then change the datasource properties in `backend/src/main/resources/application.properties`.

## AI integration
The demo uses a local mock evaluator so it works without paid services. The class `AiEvaluationService` is intentionally isolated so a real AI provider can be connected later.

## API examples
- GET `/api/health`
- GET `/api/questions?type=TECHNICAL`
- POST `/api/interviews`
- POST `/api/interviews/{id}/answers`
- GET `/api/interviews/{id}`
- POST `/api/ai/evaluate`

This is an educational portfolio project; production deployment should add stronger authentication, rate limiting, secret management, validation, monitoring, and a real AI provider.
