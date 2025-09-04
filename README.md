# Java-Template-Kit 🚀

![Java](https://img.shields.io/badge/Java-17-green?logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring_Boot-3.5.4-green?logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9.6-blue?logo=apachemaven&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-5-green?logo=junit5&logoColor=white)

[![Build and Pass Workflow](https://github.com/Pedroo-Nietoo/Java-Template-Kit/actions/workflows/build_and_test.yml/badge.svg)](https://github.com/Pedroo-Nietoo/Java-Template-Kit/actions/workflows/build_and_test.yml)

A robust and scalable project template for Java applications with Spring Boot, designed based on **Hexagonal Architecture** and **SOLID** principles. Ideal for kickstarting new microservices quickly and in an organized manner.

## Table of Contents

- [About The Project](#about-the-project)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
- [Project Architecture](#project-architecture)
    - [Hexagonal Architecture (Ports & Adapters)](#hexagonal-architecture-ports--adapters)
    - [SOLID Principles](#solid-principles)
- [API Endpoints](#api-endpoints)
- [Tests](#tests)
- [API Documentation (Swagger)](#api-documentation-swagger)
- [Docker](#docker)

---

## About The Project 🎯

This repository serves as a starting point (`template`) for developing back-end applications with Java and Spring Boot. The project structure is designed to promote low coupling and high cohesion, making the code easier to maintain, test, and evolve.

**Key Features:**
* **Java 17 & Spring Boot 3**: Uses modern and stable versions of the Java ecosystem.
* **Hexagonal Architecture**: Separates business logic (domain) from external technologies (infrastructure).
* **SOLID**: The code is structured following the five principles of object-oriented design.
* **Automated Tests**: Ready-to-go setup for unit and integration tests with JUnit 5.
* **Swagger Documentation**: Automatic generation of API documentation.
* **GitHub Actions**: CI/CD workflow for automated builds and tests.

---

## Getting Started 🏁

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* **Java Development Kit (JDK) 17** or higher.
* **Apache Maven 3.9+**.
* An IDE of your choice (IntelliJ IDEA, VS Code, Eclipse, etc.).

### Installation

1.  Clone the repository:
    ```shell
    git clone [https://github.com/Pedroo-Nietoo/Java-Template-Kit.git](https://github.com/Pedroo-Nietoo/Java-Template-Kit.git)
    ```
2.  Navigate to the project directory:
    ```shell
    cd Java-Template-Kit
    ```
3.  Install dependencies with Maven:
    ```shell
    mvn clean install
    ```
    
---

## Usage ▶️

To run the application locally, use the Spring Boot Maven plugin:

```shell
mvn spring-boot:run
```

By default, the application will start on port 8080. You can change the port and other settings in the src/main/resources/application.properties file.

## Project Architecture 🏛️
The project's structure is designed to be clean, decoupled, and easy to maintain.

### Hexagonal Architecture (Ports & Adapters)
The hexagonal architecture isolates the application's core (domain) from implementation details, such as databases, external APIs, or user interfaces.
- **Domain (domain):** Contains the pure business logic, entities, and rules. It does not depend on any external layer.
- **Application (application):** Orchestrates the data flow between the domain and the infrastructure through ports.
- **Infrastructure (infrastructure):** Implements the adapters. It contains controllers (REST), repositories (JPA), HTTP clients, and other external integrations.

This separation ensures that the business logic can be tested in isolation and that the technology stack can be swapped out with minimal impact on the rest of the system.

### SOLID Principles
The project adheres to the SOLID principles to create more understandable, flexible, and maintainable software.

## API Endpoints
Below are examples of the endpoints available in this template.

| HTTP Method | Route                      | Description                            |
|:------------|:---------------------------|:---------------------------------------|
| GET         | `/api/v1/users/{id}`       | Lists user info                        |
| GET         | `/api/v1/terms-of-service` | Redirects to the terms of service page |

## Tests 🧪
The project is configured with JUnit 5 for unit and integration tests. To run all tests, use the following Maven command:

```shell
mvn test
```

Test reports can be found in the /target/surefire-reports directory.

## API Documentation (Swagger) 📖
The API endpoint documentation is automatically generated with Springdoc (Swagger). After starting the application, you can access it at the following URLs:
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **OpenAPI Spec (JSON):** http://localhost:8080/v3/api-docs

## Docker 🐳
To facilitate deployment and ensure a consistent environment, you can run the application in a Docker container.

(Note: This section is a placeholder. Detailed instructions and the Dockerfile will be added soon.)

1. **Build the Docker image:**
```shell
docker build -t java-template-kit .
```

2. **Run the container:**
```shell
docker-compose up
```

### Grafana and Prometheus
When running the application via Docker, Grafana can be accessed at `http://localhost:3000` for login.
Prometheus runs alongside the application and serves as the data source for Grafana dashboards.
