🚗 Dealer & Vehicle Management API
A Spring Boot REST API project for managing Dealers, Vehicles, and Payments.

This project is built as part of a backend task and provides endpoints to:

Manage Dealers (CRUD operations)

Manage Vehicles (CRUD + Filter by Premium Dealers)

Manage Payments (Initiate & Retrieve payment records)

📌 Tech Stack
Java 21

Spring Boot 4.0 

Spring Data JPA

Hibernate

PostgreSQL

Lombok

Maven

🚀 Getting Started
1. Clone Repository
git clone https://github.com/Suryank08/dealer_vehicle_management.git
cd dealer_vehicle_management

2. Configure Database:
First, you'll need to create the database in your local PostgreSQL or MySQL instance. For PostgreSQL, you can use the following command:  "createdb -U your_username -W dealer_vehicle_db"

   
3. Edit your application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/dealer_vehicle_db
spring.datasource.username= "your username db"
spring.datasource.password="Your password db


spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect


spring.sql.init.mode=always
spring.sql.init.schema-locations=classpath:schema.sql
spring.sql.init.data-locations=classpath:data.sql


4. Run Application
mvn spring-boot:run

Server starts on: http://localhost:8080

📬 API Endpoints
🧑 Dealer APIs
Method

Endpoint

Description

POST

/api/dealers/

Create a new dealer

GET

/api/dealers

Get all dealers

GET

/api/dealers/{dealerId}

Get dealer by ID

POST

/api/dealers/update

Update existing dealer

Example Request (Create Dealer)

{
  "dealerName": "John Doe",
  "dealerEmail": "john@example.com",
  "subscriptionType": "PREMIUM"
}

🚘 Vehicle APIs
Method

Endpoint

Description

POST

/api/vehicles/

Create a new vehicle under a dealer

GET

/api/vehicles

Get all vehicles

GET

/api/vehicles/{vehicleId}

Get vehicle by ID

GET

/api/vehicles/premium-dealers

Get vehicles listed by PREMIUM dealers

Example Request (Create Vehicle)

{
  "dealer_id": "{{dealerId}}",
  "model": "Toyota Corolla",
  "price": 15000,
  "statusType": "AVAILABLE"
}

💳 Payment APIs
Method

Endpoint

Description

POST

/api/payments/initiate

Initiate a new payment for a dealer

GET

/api/payments

Get all payments

GET

/api/payments/{paymentId}

Get payment details by ID

Example Request (Initiate Payment)

{
  "dealer_id": "{{dealerId}}",
  "amount": 1000,
  "paymentMethodType": "UPI"
}

🔑 Environment Variables (Postman)
The following variables are pre-configured in the Postman collection:

{
  "dealerId": "b301c238-d63c-4a12-8888-085e3d7402c5",
  "vehicleId": "dcff27ae-436d-4624-823a-3ec4fa174638",
  "paymentId": "25b30e98-c620-4e0f-8158-bd0a3958b9ef"
}

You can replace them with real values after running the API.

📂 Project Structure
dealer-vehicle-management/
│── src/main/java/com/example/dealer_vehicle_management/
│   ├── controller/     # REST Controllers
│   ├── service/        # Service Layer
│   ├── dao/            # Data Access Layer (JPA Repositories)
│   ├── entity/         # JPA Entities
│   ├── enums/          # Enums (SubscriptionType, StatusType, PaymentMethodType)
│   └── DealerVehicleManagementApplication.java
│
│── src/main/resources/
│   ├── application.properties
│   └── schema.sql      # (Optional) DB schema initialization
│
└── pom.xml

📖 Postman Collection
Import the provided collection into Postman:
Dealer & Vehicle Management API.postman_collection.json

