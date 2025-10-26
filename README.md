# 📊 Logging (Monitoring) Microservice

## 📘 Overview
The **Logging Service** is a dedicated microservice responsible for collecting and analyzing logs, metrics, and system events from other services in the Task Manager ecosystem.

It receives log messages via **RabbitMQ** from the **Task Manager** and other services, stores them in **PostgreSQL**, and provides APIs to query logs by service, severity, or time range.

This service helps monitor system behavior, performance, and issues in real-time.

---

## ⚙️ Tech Stack
- **Java 21**  
- **Spring Boot 3**  
- **RabbitMQ** (Message Broker)  
- **PostgreSQL** (Database)  
- **Spring JPA / Hibernate**  
- **Lombok**  
- **Validation API**

---

## 🚀 Key Features
- Listens to `logging_queue` for all incoming log events  
- Stores logs with timestamp, log level, and source service  
- REST API for retrieving, filtering, and deleting logs  
- Enables centralized monitoring across multiple microservices  
- Supports future integration with analytics and dashboards  

---

## 🧠 System Role
This microservice acts as a **centralized event log collector**.  
Whenever another service (like Task Manager) performs an action, it publishes a log event to RabbitMQ — this service consumes and stores it.

**Example Workflow:**
1. Task Manager publishes a `LOG_EVENT` to RabbitMQ after a task is created.  
2. Logging Service consumes the message and saves it in the database.  
3. Admin or developer queries the logs using REST APIs for monitoring or debugging.  

---


## 🧩 API Overview

| Method | Endpoint | Description |
|---------|-----------|-------------|
| `GET` | `/api/logs` | Fetch all logs |
| `DELETE` | `/api/logs/{id}` | Delete a specific log entry |

---
