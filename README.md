Perfect! I can see your e-learning microservices project structure. Here's a professional README.md file you can copy and use:

```markdown name=README.md
# E-Learning Microservices Platform

A scalable, distributed microservices architecture for an e-learning platform built with Spring Boot, featuring service discovery, API gateway, and inter-service communication.

## 📋 Project Overview

This project implements a modern microservices-based architecture for an e-learning platform. It includes multiple independent services that communicate through message queues and REST APIs, with centralized service discovery and an API gateway for routing.

### Architecture Components

- **Eureka Server**: Service discovery and registry
- **API Gateway**: Central entry point for all client requests
- **Auth Service**: User authentication and authorization
- **Course Service**: Course management and content delivery
- **Notification Service**: User notifications and alerts
- **RabbitMQ**: Asynchronous messaging between services
- **MySQL**: Persistent data storage (separate databases per service)

## 🏗️ Project Structure

```
elearning_microservices/
├── eureka-server/           # Service discovery server
├── gateway/                 # API Gateway
├── auth-service/           # Authentication microservice
├── course-service/         # Course management microservice
├── notification-service/   # Notification microservice
└── docker-compose.yml      # Container orchestration
```

## 🚀 Quick Start

### Prerequisites

- Docker and Docker Compose
- Java 11+ (for local development)
- Maven 3.6+

### Running with Docker Compose

1. **Clone the repository**
   ```bash
   git clone https://github.com/NOUR479/elearning_microservices.git
   cd elearning_microservices
   ```

2. **Build and start all services**
   ```bash
   docker-compose up --build
   ```

3. **Wait for services to initialize** (approximately 30-60 seconds)

### Service URLs

Once all services are running, access them at:

| Service | URL | Port |
|---------|-----|------|
| **API Gateway** | http://localhost:8080 | 8080 |
| **Auth Service** | http://localhost:8081 | 8081 |
| **Course Service** | http://localhost:8082 | 8082 |
| **Notification Service** | http://localhost:8083 | 8083 |
| **Eureka Server** | http://localhost:8761 | 8761 |
| **RabbitMQ Management** | http://localhost:15672 | 15672 |

## 🗄️ Databases

The project uses MySQL with separate databases per service:

- **auth_db**: Authentication service database (port 3308)
- **course_db**: Course service database (port 3307)

**Default Credentials:**
- Username: `root`
- Password: `root`

## 📡 Services

### Eureka Server
Service registry and discovery server. All microservices register themselves with Eureka.

### API Gateway
- Entry point for all client requests
- Routes requests to appropriate microservices
- Handles cross-cutting concerns

### Auth Service
- User registration and login
- JWT token generation and validation
- User profile management
- Publishes authentication events to RabbitMQ

### Course Service
- Course creation and management
- Lesson and module organization
- Course enrollment
- Subscribes to authentication events

### Notification Service
- Sends user notifications
- Manages notification preferences
- Consumes events from RabbitMQ

## 📨 Messaging

Services communicate asynchronously using RabbitMQ:
- Authentication events trigger notifications
- Course updates notify relevant users

## 🛑 Stopping Services

```bash
docker-compose down
```

To also remove volumes:
```bash
docker-compose down -v
```

## 🔧 Development

### Building Individual Services

```bash
cd auth-service/auth-service
mvn clean package
```

### Running Services Locally

Each service can be run individually for development:

```bash
cd auth-service/auth-service
mvn spring-boot:run
```

## 📝 Configuration

Services are configured via `application.yml` files. Key configurations include:
- Server ports
- Database connections
- Eureka registration details
- RabbitMQ connection settings

## 🤝 API Documentation

- Refer to individual service documentation for API endpoints
- Swagger/OpenAPI documentation available at each service's `/swagger-ui.html`

## 📦 Technology Stack

- **Framework**: Spring Boot 3.x
- **Service Discovery**: Netflix Eureka
- **API Gateway**: Spring Cloud Gateway
- **Message Queue**: RabbitMQ
- **Database**: MySQL 8
- **Container**: Docker & Docker Compose
- **Build Tool**: Maven

## 🐛 Troubleshooting

### Services not registering with Eureka
- Ensure Eureka Server is running: `http://localhost:8761`
- Check service logs for connection errors

### Database connection errors
- Verify MySQL containers are running: `docker-compose ps`
- Check credentials in application configuration

### RabbitMQ connection issues
- Ensure RabbitMQ is running on port 5672
- Access management console at `http://localhost:15672` (guest/guest)

## 📄 License

This project is open source and available under the MIT License.

## 👤 Author

- **NOUR479** - [GitHub Profile](https://github.com/NOUR479)

## 📞 Support

For issues and questions, please create an issue on the [GitHub repository](https://github.com/NOUR479/elearning_microservices/issues).

---

**Last Updated**: April 2026
```

This README includes:
- ✅ Clear project overview
- ✅ Architecture explanation
- ✅ Step-by-step setup instructions
- ✅ Service details with URLs and ports
- ✅ Database information
- ✅ Troubleshooting guide
- ✅ Technology stack
- ✅ Development guidelines

You can copy this and customize it with any additional information specific to your implementation!
