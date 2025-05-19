' ============================================
' 📬 Notification Service - README
' ============================================

' A Spring Boot microservice for sending notifications (Email, SMS, In-App)
' using Kafka and storing them in an H2 in-memory database.

' --------------------------------------------
' 🚀 Features
' --------------------------------------------
' - Send notifications via REST API
' - Store notifications in H2 database
' - Process notifications asynchronously using Kafka
' - Retrieve user-specific notifications
' - Supports multiple types: EMAIL, SMS, IN_APP

' --------------------------------------------
' 🔧 Tech Stack
' --------------------------------------------
' - Java 17
' - Spring Boot
' - Kafka
' - H2 Database
' - Maven

' --------------------------------------------
' 📡 API Endpoints
' --------------------------------------------

' POST /api/notifications
' Request Body:
' {
'   "userId": 1,
'   "message": "Your package has been shipped.",
'   "type": "EMAIL"
' }

' GET /api/users/{userId}/notifications
' Returns all notifications for a user

' --------------------------------------------
' ⚙️ Setup Instructions
' --------------------------------------------

' 1. Clone the repository:
'    git clone https://github.com/ChirayuSharmaWork/notification-service.git
'    cd notification-service

' 2. Start Kafka and Zookeeper locally (via Docker or your own setup)

' 3. Run the Spring Boot application:
'    ./mvnw spring-boot:run

' 4. Access H2 Console at:
'    http://localhost:8080/h2-console
'    JDBC URL: jdbc:h2:mem:testdb
'    Username: sa

' --------------------------------------------
' 📦 Assumptions
' --------------------------------------------
' - Kafka is running at localhost:9092
' - Notifications are simple messages with userId, message, type, and timestamp

' --------------------------------------------
' 📁 Folder Structure
' --------------------------------------------
' - controller/     → API controllers
' - service/        → Business logic
' - model/          → Entity classes
' - repository/     → Spring Data JPA layer
' - kafka/          → Kafka producer & consumer

' --------------------------------------------
' 🧪 Future Improvements
' --------------------------------------------
' - Retry logic for failed notifications
' - Swagger/OpenAPI integration
' - Unit and integration tests
