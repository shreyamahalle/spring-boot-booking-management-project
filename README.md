# foodease-food-ordering-booking-system
## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technology Stack](#Technology-Stack)
- [Getting Started](#Getting-Started)
- [Installation and Setup](#Installation-and-Setup)
- [API Endpoints (CRUD)](#api-endpoints-crud)
- [Postman Collection](#Postman-Collection)
- [Module Responsibilities](#Module-Responsibilities)
- [Spring Annotations](#Spring-Annotations)
- [Code Structure ](#Code-Structure )
- [Database Schema (POJO Classes)](#Database-Schema-(POJO-Classes))
- [Class Diagram](#Class-Diagram)
- [Contact](#contact)
- [Best Practices Followed](#Best-Practices-Followed)
- [Future Scope](#Future-Scope)
- [License](#license)
- [Author](#Author)

# **spring-booking-management-project**

Welcome to the Spring Booking Management Project, a simple yet powerful Java application that simulates a booking management system. This project is built using the
Spring Framework (XML-based configuration only) and applies solid Object-Oriented Programming (OOP) principles.

> **Use case**: A food ordering platform where customers can register, explore nearby restaurants, place orders, and get deliveries from available agents based on location and serviceability.

## Introduction

## Project Overview

The Spring Booking Management System provides a modular approach to managing:

 - Customers
 - Restaurants
 - Delivery Agents
 - Orders

It mimics real-world operations like customer registration, restaurant assignment, order placing, and delivery
tracking — all managed using a clean layered architecture (Controller → Service → Repository).

---

## Features

## Key Features

-  Customer and Restaurant Booking Management: Effortlessly handle customer bookings and restaurant data.
-  Delivery Agent Simulation: Assign delivery agents based on location and availability.
-  Dynamic Order Handling: Add, track, and manage orders through their entire lifecycle.
-  Seamless Java Integration: Clean integration of Java models for each entity (Customer, Delivery Agent, Order,
  Restaurant).
-  Easy-to-Follow Structure: Well-documented, clean code for learning and demonstration.
-  Layered Architecture: Clean separation of concerns.
-  REST API: Full CRUD functionality exposed via REST.
  
---

## Technology Stack

This project is built with the following technologies:


| Technology        | Purpose                                   |
|------------------|-------------------------------------------|
| Java 21           | Core language                            |
| Spring Boot       | Application framework                    |
| Spring Web        | RESTful APIs                             |
| Spring Data JPA   | Database operations                      |
| Hibernate         | ORM mapping                              |
| JSP/Servlets      | Web interface                            |
| MySQL             | Relational database                      |
| Maven             | Project management and build             |
| Lombok            | Boilerplate reduction                    |
| HTML5/CSS3        | Frontend structure                       |
| Git               | Version control                          |
| Postman           | API Testing                              |
---

## Getting Started


## Installation and Setup

### Prerequisites

Before you begin, ensure you have the following:

- **Java Development Kit (JDK) 21**: Install the latest JDK for optimal performance.
- **Maven**: Make sure Maven is installed to handle the project build.
- **MySQL Database**: You'll need to have MySQL installed and set up to manage your data.
- **Apache Tomcat**: A servlet container for running your web application.
- **IDE**: Use IntelliJ IDEA, Eclipse, or any Java IDE you're comfortable with.
- **Git (optional)**: For version control and easier collaboration.

## Steps to Get Started

## 1. **Clone the Repository:**

   ```bash
   git clone (https://github.com/shreyamahalle/spring-boot-food-order-management-system.git)
```

## 2. **Navigate to the Project Directory:**

```bash
 cd spring-boot-booking-management-project
```

## 3. **Open the Project in Your Preferred IDE:**

```bash

 Launch your IDE (IntelliJ, Eclipse, etc.), and open the cloned repository.
```

## 4. **Set up the MySQL Database:**

```bash
  CREATE DATABASE booking_management;
  USE booking_management;
```

## 5. **MySQL Database Setup**
- To set up the database and create the necessary tables, run the following SQL queries:
```bash
 -Insert sample data into the Customer table
  INSERT INTO Customer (name, username, mobileNo, city, area)
  
 -VALUES ('John Doe', 'johndoe123', '123-456-7890', 'New York', 'Manhattan');

```

## 6. **Configure Your MySQL Connection:**

- In your project configuration (application.properties), set the MySQL database connection details.

- Example application.properties:

- spring.datasource.url=jdbc:mysql://localhost:3306/booking_management
- spring.datasource.username=root
- spring.datasource.password=your_password
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

## 7. **Compile and Run the Application:**

- Locate Main.java in your IDE.

- Run the file to launch the application.

## 8. **Build the project:**

   ```bash
   mvn clean install
   ```
## API Endpoints (CRUD)

### 🧍 Customer APIs

| Method | Endpoint             | Description               |
|--------|----------------------|---------------------------|
| GET    | `/api/customers`     | Get all customers         |
| GET    | `/api/customers/{id}`| Get customer by ID        |
| POST   | `/api/customers`     | Add a new customer        |
| PUT    | `/api/customers/{id}`| Update existing customer  |
| DELETE | `/api/customers/{id}`| Delete customer by ID     |

---

### 🍽️ Restaurant APIs

| Method | Endpoint               | Description                 |
|--------|------------------------|-----------------------------|
| GET    | `/api/restaurants`     | Get all restaurants         |
| POST   | `/api/restaurants`     | Add a restaurant            |
| PUT    | `/api/restaurants/{id}`| Update restaurant           |
| DELETE | `/api/restaurants/{id}`| Delete restaurant           |

---

### 📦 Order APIs

| Method | Endpoint         | Description               |
|--------|------------------|---------------------------|
| GET    | `/api/orders`    | Get all orders            |
| POST   | `/api/orders`    | Place new order           |
| PUT    | `/api/orders`    | Update order details      |
| DELETE | `/api/orders `   | Delete order by ID        |

---

### 🛵 Delivery Agent APIs

| Method | Endpoint                | Description                |
|--------|-------------------------|----------------------------|
| GET    | `/api/agents`           | Get all delivery agents    |
| POST   | `/api/agents`           | Add a delivery agent       |
| PUT    | `/api/agents/{id}`      | Update agent details       |
| DELETE | `/api/agents/{id}`      | Delete agent by ID         |

---
## Postman Collection

You can test the REST APIs using Postman:

### 🌐 Sample JSON for POST requests:

**POST /api/customers**

```json
{
  "name": "John Doe",
  "username": "john123",
  "mobileNo": "1234567890",
  "city": "Mumbai",
  "area": "Andheri"
}
``` 
## POST /api/restaurants
```json
{
  "name": "Pizza Palace",
  "city": "Mumbai",
  "area": "Bandra"
}
```
POST /api/orders
```json
{
  "customerId": 1,
  "restaurantId": 2,
  "deliveryAgentId": 3
}
```
## Module Responsibilities

- **Customer**: Handles user registration, city/area resolution, and personalization.
- **Restaurant**: CRUD operations and geo-based filtering logic.
- **Order**: Links Customers to Restaurants; encapsulates logistics and contact info.
- **Delivery Agent**: Assignments and delivery lifecycle management.
  
## Spring Annotations

- Overview of Spring Annotations
  In this project, Spring annotations replace XML-based configuration for defining beans, enabling easier configuration
  and management of the application. The following annotations are used:

1. @Configuration
   Description: Marks the class as a source of bean definitions for the application context. This is used in place of
   XML configuration files.

2. @ComponentScan
   Description: Tells Spring to scan the specified base package(s) for annotated components (like @Service, @Controller,
   @Repository, etc.) and register them as beans in the Spring context.

3. @Service
   Description: Indicates that a class is a service, which typically holds business logic. It's a specialization of
   @Component.

4. @Repository
   Description: Marks a class as a Data Access Object (DAO), typically used for database-related operations. It also
   provides exception translation.

5. @Controller
   Description: Marks a class as a Spring MVC controller, handling incoming HTTP requests.
6. @Autowired
   Description: Automatically injects the dependencies into the Spring beans. It can be used on fields, constructors, or
   setter methods.
7. @Bean
   Description: Used to define a bean within a @Configuration annotated class. It's a method-level annotation.
   

## Contact

For any questions or suggestions, feel free to open an issue or contact me directly:

- **GitHub:** [Shreya Mahalle](https://github.com/shreyamahalle)

---

*This README was generated by [Shreya Mahalle](https://github.com/shreyamahalle).*

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Code Structure 

```
src/
└── main/
    ├── java/
    │   └── com.booking
    │       ├── config/             # App configuration
    │       ├── controller/         # REST controllers
    │       ├── model/              # Entity classes
    │       ├── repository/         # Data access interfaces
    │       ├── service/            # Business logic
    │       └── BookingApplication  # Main class
    └── resources/
        ├── application.properties
        └── static/templates

```

## **Functionality**

1. **Customer**
2. **DeliveryAgent**
3. **Order**
4. **Restaurant**

## **🔧 Core Functionality**

1. Customer Management
   Allows you to create and manage customer information such as name, username, contact details, and address.

2. Delivery Agent Management
   Adds delivery agents, assigns them to orders, and tracks their delivery status.

3. Order Management
   Manages the creation, display, and tracking of customer orders from placement to delivery.

4. Restaurant Management
   Registers new restaurants, displays restaurant details, and associates them with orders.

## Database Schema (POJO Classes)

| **Entity**        | **Attributes**                              |
|-------------------|---------------------------------------------|
| **Customer**      | user id, name, username,monbileNo,city,area |
| **DeliveryAgent** | id, name, city, mobileNo                    |
| **Order**         | id, name, city, mobileNo                    |
| **Restaurant**    | registerNo, name, City, Area                |

---

## Class Diagram

```mermaid
---
title: booking management project
---
classDiagram

 note " food order management "

 class Customer
 Customer : +int ID
 Customer : +String name
 Customer : +String city
 Customer : +int age
 Customer : +int contactNo

class Customer{
 +createCustomer()
 +displayCustomer()
}

class DeliveryAgent
DeliveryAgent : +int id
DeliveryAgent : +String name
DeliveryAgent : +String city
DeliveryAgent : +mobileNo

class DeliveryAgent{
+createDeliveryAgent()
+displayDeliveryAgent()
}

  Customer --|> Order  : Inheritance
class Order{
 +createOrder()
 +displayOrder()
}
 Order : +int Id
 Order : +String name
 Order : +String lastName
 Order : +int age
 Order : +int contactNo
 Order : +String address

class Order{
 +createOrder()
 +displayOrder()
}

Restaurant: +int registerNo
Restaurant: +String Name
Restaurant: +String city
Restaurant: +String Area
Restaurant: +int contactNo

class Restaurant{
 +createRestaurant()
 +displayRestaurant()
}

Customer <-- Order : Association
DeliveryAgent  <-- Order  : Assocciation


Restaurant --> Customer : Association
Restaurant --> Order : Association
Restaurant --> DeliveryAgent : Association

Customer --> DeliveryAgent : Association




```
## Best Practices Followed
- MVC Layering: Each layer has a single responsibility and adheres to open/closed principle.
- Exception Handling: Extendable @ControllerAdvice class can be added for custom error management.
- Validation: javax.validation annotations (future improvement) to enforce domain constraints.
- DTO Mapping: DTOs can be introduced for request/response abstraction (optional enhancement).
- Lombok: Reduces boilerplate while maintaining readability.

## Future Scope
- Add unit tests using JUnit + Mockito
- API authentication using Spring Security or JWT
- Integration with Kafka or RabbitMQ for event-driven order tracking
- CI/CD with GitHub Actions
- Dockerization and deployment to Kubernetes or AWS ECS
  
---

## Author

Shreya Mahalle  
[GitHub](https://github.com/shreyamahalle) | [LinkedIn](https://linkedin.com/in/shreyamahalle)

---

