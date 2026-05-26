# BFHL REST API - Spring Boot Application

This project is a production-ready, highly robust Spring Boot implementation for the BFHL (Bajaj Finserv Health Limited) API round.

## Tech Stack
- **Language**: Java 21
- **Framework**: Spring Boot 3.x
- **Build Tool**: Maven

## Credentials Used
- **User ID**: `sarvesh_jadia_07042005`
- **Email**: `sarveshjadia230885@acropolis.in`
- **Roll Number**: `0827CS231240`

---

## API Documentation

### 1. Process Data (POST)
Processes an array of strings, separating numbers, alphabets, and special characters, computing sums, and reversing alphabetical characters with alternating capitalization.

- **Route**: `/bfhl`
- **Method**: `POST`
- **Content-Type**: `application/json`
- **Successful Status Code**: `200 OK`

#### Request Body
```json
{
  "data": ["a", "1", "334", "4", "R", "$"]
}
```

#### Response Body
```json
{
  "is_success": true,
  "user_id": "sarvesh_jadia_07042005",
  "email": "sarveshjadia230885@acropolis.in",
  "roll_number": "0827CS231240",
  "odd_numbers": ["1"],
  "even_numbers": ["334", "4"],
  "alphabets": ["A", "R"],
  "special_characters": ["$"],
  "sepcial_characters": ["$"],
  "sum": "339",
  "concat_string": "Ra"
}
```

### 2. Get Operation Code (GET)
A fallback endpoint that returns a status operation code.

- **Route**: `/bfhl`
- **Method**: `GET`
- **Successful Status Code**: `200 OK`

#### Response Body
```json
{
  "operation_code": 1
}
```

---

## Getting Started

### Prerequisites
- Java 21 or higher installed.

### Build the Project
To compile the source code, run the unit/integration tests, and package the application into an executable JAR:
```bash
mvn clean package
```

The compiled JAR will be located in the `target/` directory: `target/bfhl-0.0.1-SNAPSHOT.jar`.

### Run the Application
You can run the executable JAR locally:
```bash
java -jar target/bfhl-0.0.1-SNAPSHOT.jar
```
The application will start on port `8080` (or the port specified by the `PORT` environment variable).
