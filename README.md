# Spring Boot Fundamentals Practice Project

This is a simple Java Spring Boot application created to practice and solidify the fundamentals of building RESTful APIs using Spring Boot.
The application demonstrates basic CRUD operations (`POST`, `GET`, `PUT`, and `DELETE`) using a PostgreSQL database for persistent storage. 
It also integrates Swagger UI for API exploration and testing.

## 🚀 Features

- RESTful API with Spring Boot
- PostgreSQL integration for data persistence
- API documentation and testing via Swagger UI
- Basic Create, Read, Update, and Delete operations
- Structured for easy expansion and scalability

## 🛠️ Tech Stack

- **Java**
- **Spring Boot**
- **PostgreSQL**
- **Swagger UI / Springdoc OpenAPI**
- **Maven**

## 🧪 Endpoints

The app currently supports the following endpoints:

- `POST /api/v1/student` — Create a new student
- `GET /api/v1/student` — Retrieve all students
- `PUT /api/v1/student/{studentId}` — Updates a single student based on its Id, can update name and/or email
- `DELETE /api/v1/student/{studentId}` — Delete an object by ID

You can test all of these endpoints directly via the Swagger UI.

### Swagger UI

Once the app is running, access Swagger UI at: http://localhost:8080/swagger-ui/index.html#/

📚 Learning Goals
This project was built with the following learning objectives in mind:

Practice building REST APIs with Spring Boot

Learn to connect a Spring application to a PostgreSQL database

Use Swagger/OpenAPI for documentation and testing

Understand layered architecture (Controller-Service-Repository)

Get comfortable with application setup and configuration

🧑‍💻 Author

Name: Christopher Canenguez

GitHub: @christopher-canenguez

LinkedIn: https://www.linkedin.com/in/christopher-canenguez-81332321b/

