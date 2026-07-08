# Real-Time Chat Application

A GitHub-ready real-time chat application built with Java, Spring Boot, WebSockets, STOMP, and MySQL.

## Features

- Real-time public chat using WebSockets
- STOMP message broker for low-latency updates
- REST API to fetch recent chat history
- MySQL persistence for chat messages
- Simple browser UI included in `src/main/resources/static`

## Tech Stack

- Java 17
- Spring Boot 3
- Spring WebSocket
- Spring Data JPA
- MySQL
- Maven

## Project Structure

```text
src/main/java/com/example/realtimechat
  config/        WebSocket configuration
  controller/    REST and WebSocket controllers
  dto/           Message request/response models
  model/         JPA entities
  repository/    Database repositories
  service/       Chat business logic
src/main/resources/static
  index.html     Browser chat client
```

## Prerequisites

- Java 17 or newer
- Maven 3.9 or newer
- MySQL 8 or newer

## Database Setup

Create the database:

```sql
CREATE DATABASE realtime_chat;
```

Update `src/main/resources/application.properties` with your MySQL username and password:

```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

## Run Locally

```bash
mvn spring-boot:run
```

Open the app:

```text
http://localhost:8080
```

Open the page in two browser tabs, enter different names, and send messages to test real-time delivery.

## API Endpoints

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/api/messages` | Returns recent chat messages |

## WebSocket Destinations

| Destination | Purpose |
| --- | --- |
| `/ws-chat` | WebSocket connection endpoint |
| `/app/chat.send` | Client sends chat messages |
| `/topic/messages` | Clients receive broadcast messages |

## GitHub Setup

```bash
git add .
git commit -m "Initial real-time chat application"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/realtime-chat-application.git
git push -u origin main
```
