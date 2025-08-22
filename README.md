
# 🚗 Dealer & Vehicle Management API

This is a Spring Boot REST API project for managing dealers, vehicles, and payments. It was built as a backend task and provides a complete set of endpoints for a car dealership platform.

---

## ✨ Features

* **Dealer Management:** Perform full CRUD (Create, Read, Update, Delete) operations on dealer information.
* **Vehicle Management:** Manage vehicles, with the added functionality to filter vehicles listed by premium dealers.
* **Payment Management:** Initiate new payments and retrieve historical payment records.

---

## 🛠️ Tech Stack

* **Java 21:** The core programming language.
* **Spring Boot 4.0:** The framework used to build the application.
* **Spring Data JPA & Hibernate:** For data persistence and database interaction.
* **PostgreSQL:** The primary relational database.
* **Lombok:** A library to reduce boilerplate code.
* **Maven:** The build automation tool.

---

## 🚀 Getting Started

Follow these steps to get the project up and running on your local machine.

### 1. Configure the Database

This project uses PostgreSQL. First, you need to create the database locally (bash command given below).

```bash
sudo -u postgres createdb dealer_vehicle_db
````

### 2\. Update `application.properties`

Navigate to `src/main/resources/application.properties` and update the database connection details with your credentials.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dealer_vehicle_db
spring.datasource.username= "your username db"
spring.datasource.password="Your password db"

spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Initializes the database schema and data from the provided SQL files
spring.sql.init.mode=always
spring.sql.init.schema-locations=classpath:schema.sql
spring.sql.init.data-locations=classpath:data.sql
```

> **Note:** The `schema.sql` and `data.sql` files will automatically set up the database structure and populate it with sample data on startup.

### 3\. Run the Application

Execute the following command in your terminal to start the Spring Boot application.

```bash
mvn spring-boot:run
```

-----

## 📬 API Endpoints
For easy testing, you can import the provided Postman collection.

* **File:** [Dealer & Vehicle Management API.postman_collection.json](Dealer%20&%20Vehicle%20Management%20API.postman_collection.json) 
All endpoints are prefixed with `/api`.
#### Test DealerId : `b301c238-d63c-4a12-8888-085e3d7402c5`
### 🧑 Dealer APIs

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/dealers/` | Creates a new dealer. |
| `GET` | `/api/dealers` | Retrieves a list of all dealers. |
| `GET` | `/api/dealers/{dealerId}` | Retrieves a specific dealer by their ID. |
| `POST` | `/api/dealers/update` | Updates an existing dealer's details. |

**Example Request (Create Dealer)**

```json
{
  "dealerName": "John Doe",
  "dealerEmail": "john@example.com",
  "subscriptionType": "PREMIUM"
}
```

### 🚘 Vehicle APIs

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/vehicles/` | Creates a new vehicle under a specific dealer. |
| `GET` | `/api/vehicles` | Retrieves a list of all vehicles. |
| `GET` | `/api/vehicles/{vehicleId}` | Retrieves a specific vehicle by its ID. |
| `GET` | `/api/vehicles/premium-dealers` | Retrieves vehicles listed exclusively by premium dealers. |

**Example Request (Create Vehicle)**

```json
{
  "dealer_id": "{{dealerId}}",
  "model": "Toyota Corolla",
  "price": 15000,
  "statusType": "AVAILABLE"
}
```

### 💳 Payment APIs

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/payments/initiate` | Initiates a new payment for a dealer. |
| `GET` | `/api/payments` | Retrieves a list of all payment records. |
| `GET` | `/api/payments/{paymentId}` | Retrieves the details of a specific payment by its ID. |

**Example Request (Initiate Payment)**

```json
{
  "dealer_id": "{{dealerId}}",
  "amount": 1000,
  "paymentMethodType": "UPI"
}
```

-----

## 🌐 Key URLs & Resources

  * **GitHub Repository:** `https://github.com/Suryank08/dealer_vehicle_management.git`
  * **Local Server:** `http://localhost:8080`
  * **Payment Gateway URL:** `http://localhost:8080/index.html`
  * **Postman Collection File:** `Dealer & Vehicle Management API.postman_collection.json`

-----

## 📂 Project Structure

```
dealer-vehicle-management/
│── src/main/java/com/example/dealer_vehicle_management/
│   ├── controller/      # REST Controllers
│   ├── service/         # Service Layer
│   ├── dao/             # Data Access Layer (JPA Repositories)
│   ├── entity/          # JPA Entities
│   ├── enums/           # Enums (SubscriptionType, StatusType, PaymentMethodType)
│   └── DealerVehicleManagementApplication.java
│
│── src/main/resources/
│   ├── application.properties
│   ├── schema.sql       # Database schema initialization
│   └── data.sql         # Sample data
│
└── pom.xml              # Maven configuration
