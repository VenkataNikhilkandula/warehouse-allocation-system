# 📦 Warehouse Allocation System

A robust **enterprise-level Warehouse Allocation System** built using **Java + Spring Boot**, designed to manage product distribution across multiple warehouses, prevent over-allocation, and maintain complete allocation history for auditing.

---

## 🚀 Features

### 🏬 Warehouse Management

* Create, update, activate, and deactivate warehouses
* Maintain warehouse-level inventory

### 📦 Inventory Management

* Track product stock across multiple warehouses
* Prevent over-allocation of stock
* Real-time inventory updates

### 🔄 Stock Allocation & Transfer

* Allocate products to specific warehouses
* Transfer stock between warehouses
* Maintain complete transfer history

### 👤 User Management (Basic)

* Create and manage users
* Secure authentication (JWT-based)

----
## 🏗️ Project Architecture

This project follows a clean layered architecture:

com.warehouse
│
├── controller # REST API controllers
├── dto # Request & Response DTOs
├── entity # JPA Entities
├── repository # Database access layer
├── service # Business logic layer
├── serviceimpl # Service implementations
└── enums # Enums classes

---

## ⚙️ Tech Stack

* **Backend:** Java, Spring Boot
* **Database:** MySQL
* **Build Tool:** Maven
* **ORM:** Spring Data JPA / Hibernate

---

## 🛠️ Setup & Installation

### 1️⃣ Clone Repository

```bash
git clone https://github.com/VenkataNikhilkandula/warehouse-allocation-system.git
cd warehouse-allocation-system
```

### 2️⃣ Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/warehouse_db
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3️⃣ Run Application

```bash
mvn spring-boot:run
```

App will start at:

```
http://localhost:8080
```

---

## 🔌 API Endpoints (Sample)

### 👤 User APIs

* POST `/auth/register` → Register user
* POST `/auth/login` → Login & get JWT

### 🏬 Warehouse APIs

* POST `/warehouses`
* GET `/warehouses`
* PUT `/warehouses/{id}`
* DELETE `/warehouses/{id}`

### 📦 Inventory APIs

* GET `/inventory`
* POST `/inventory/add`

### 🔄 Stock Transfer APIs

* POST `/transfer`
* GET `/transfer/history`

---

## 🧪 Testing

Use tools like:

* Postman

## 📁 .gitignore (Important)

```
target/
*.log
*.class
.env
.idea/
.eclipse/
```
