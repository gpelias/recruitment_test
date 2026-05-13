# DWS Recruitment Test - Bands API

This repository contains the backend implementation for the DWS technical test. The application is a RESTful API built to integrate with an external provider, apply business rules, and deliver optimized data to front-end clients.

## 🌐 Live Demo & Documentation
The application is deployed and available for testing at the following links:
* **Live API:** [https://recruitment-test-c6rj.onrender.com/](https://recruitment-test-c6rj.onrender.com/)
* **Swagger UI (Interactive Docs):** [https://recruitment-test-c6rj.onrender.com/swagger-ui/index.html#/](https://recruitment-test-c6rj.onrender.com/swagger-ui/index.html#/)

## 🚀 Tech Stack & Core Decisions
* **Java 25 & Spring Boot 4**: Leveraging the latest features and performance improvements.
* **OpenFeign**: Clean and declarative integration with the external Vercel API.
* **Caffeine Cache**: Implemented a robust in-memory caching layer to prevent rate-limiting and ensure blazing-fast response times.
* **Dynamic Filtering & Sorting Engine**: Built a highly reusable utility using **Java Reflection and Streams** to dynamically filter and sort data based on multiple query parameters simultaneously (e.g., `?genre=rock&sort=numPlays&order=desc`).
* **Global Exception Handling**: Centralized error management to elegantly handle external API downtimes (`502 Bad Gateway`) and internal errors, preventing stack traces from leaking to the client.
* **OpenAPI 3 (Swagger)**: Fully documented endpoints with mapped schemas and dynamic query parameters.
* **Docker & Docker Compose**: Multi-stage build process utilizing AWS Corretto base images for a lightweight and production-ready container.
* **CI/CD**: Configured GitHub Actions for continuous integration and automated build verification.

## ⚙️ How to Run (Docker)

The easiest way to run the application is using Docker Compose.

1. Clone this repository.
2. Run the following command in the root directory:
   ```bash
   docker compose up -d --build