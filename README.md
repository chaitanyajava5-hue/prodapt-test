# Personal Book Service

This project is a Spring Boot application that integrates with the **Google Books API** to fetch book information and persist it into a local database.

The service exposes REST APIs to search books using the Google Books API and store the results in the database.

---

# Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- MapStruct
- Maven
- JUnit & Mockito

---

# Features

- Calls **Google Books API**
- Stores book data in **H2 Database**
- Uses **MapStruct** for DTO mapping
- Proper **layered architecture**
- **Global exception handling**
- **Logging**
- **Unit Tests**
- **Integration Test (real Google API call)**

---

# Project Structure

```

src/main/java
└── com.example.demo
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── google
└── exception

```

---

# Prerequisites

Make sure the following are installed:

- Java 17+
- Maven 3.8+
- Git

---

# Configuration

Add your **Google Books API key** in:

```

src/main/resources/application.properties

```

Example:

```

google.books.base-url=[https://www.googleapis.com/books/v1](https://www.googleapis.com/books/v1)
google.books.api-key=YOUR_API_KEY

```

You can generate a Google Books API key from:

https://console.cloud.google.com/apis/library/books.googleapis.com

---

# How to Run the Application

### 1. Clone the repository

```

git clone [https://github.com/chaitanyajava5-hue/prodapt-test.git](https://github.com/chaitanyajava5-hue/prodapt-test.git)

```

### 2. Navigate to project folder

```

cd prodapt-test

```

### 3. Build the project

```

mvn clean install

```

### 4. Run the application

```

mvn spring-boot:run

```

Application will start on:

```

http://localhost:8080

```

---

# H2 Database Console

You can access the H2 console at:

```

[http://localhost:8080/h2-console](http://localhost:8080/h2-console)

```

Use the following credentials:

```

JDBC URL: jdbc:h2:mem:books
User: sa
Password:

```

---

# API Endpoints

## 1. Fetch books from Google API

```

GET /google?q=java

```

Example:

```

[http://localhost:8080/google?q=java](http://localhost:8080/google?q=java)

```

---

## 2. Get all saved books

```

GET /books

```

Example:

```

[http://localhost:8080/books](http://localhost:8080/books)

```

---

# Running Tests

Run all tests using:

```

mvn test

```

Tests include:

- Controller tests
- Service tests
- Repository tests
- Integration tests

---

# Error Handling

The application handles the following errors from Google Books API:

- 404 – Resource not found
- 500 – Internal server error
- 502 – Bad gateway
- 503 – Service unavailable
- 504 – Gateway timeout

---

# Logging

Application uses **Spring Boot logging** to log:

- API calls
- errors
- request/response details

---

# Assumptions

- Google Books API is publicly accessible.
- Only basic book fields are stored in the database.
- H2 in-memory database is used for simplicity.

---

---
# Sample Output

### Google Books API Response

The following screenshot shows the response returned from the Google Books API.

<img width="855" height="640" alt="Screenshot 2026-03-12 at 8 38 56 AM" src="https://github.com/user-attachments/assets/8d50ed41-dd3e-4c3c-b70c-9592ec18498b" />


### Books Retrieved from Database

The following screenshot shows the books stored in the database.

<img width="982" height="673" alt="Screenshot 2026-03-12 at 8 39 06 AM" src="https://github.com/user-attachments/assets/ce1df773-4a37-49fe-a98d-a42dd7f230b6" />


# Author

Chaitanya Kandula
