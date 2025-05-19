# 📬 Notification Service

A Spring Boot microservice for sending notifications (Email, SMS, In-App) using Kafka and storing them in an H2 in-memory database.

---

## 🚀 Features

- Send notifications via REST API  
- Store notifications in H2 database  
- Process notifications asynchronously using Kafka  
- Retrieve user-specific notifications  
- Supports multiple types: EMAIL, SMS, IN_APP

---

## 🔧 Tech Stack

- Java 17  
- Spring Boot  
- Apache Kafka  
- H2 Database  
- Maven

---

## 📡 API Endpoints

### POST `/api/notifications`

Sends a new notification.

**Example Request Body:**

json
{
  "userId": 1,
  "message": "Your package has been shipped.",
  "type": "EMAIL"
}
GET /api/users/{userId}/notifications
Retrieves all notifications for the specified user.

## ⚙️ Setup Instructions

- 1. Clone the repository
- git clone https://github.com/ChirayuSharmaWork/notification-service.git
- cd notification-service
- 2. Start Kafka and Zookeeper locally
- You can use Docker or any other method. Make sure Kafka is running on localhost:9092.

- Example Docker command to start Kafka and Zookeeper:

- docker-compose up -d
- (Make sure you have a docker-compose.yml file configured for Kafka and Zookeeper or follow Kafka's official setup instructions.)

- 3. Run the Spring Boot application
- ./mvnw spring-boot:run
- 4. Access the H2 Console
- Open your browser and go to: http://localhost:8080/h2-console
- Use the following credentials:
- JDBC URL: jdbc:h2:mem:testdb
- Username: sa

