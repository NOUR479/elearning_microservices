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
