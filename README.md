# Temu Discord 

> A real-time chat application built with Spring Boot and WebSockets, featuring chat rooms and instant messaging.

## Features

- Create and join chat rooms
- Real-time messaging using WebSockets
- Message history with pagination
- PostgreSQL database persistence

## Tech Stack

- **Backend**: Spring Boot 3.x
- **Database**: PostgreSQL
- **Real-time**: WebSocket (STOMP)
- **ORM**: Spring Data JPA / Hibernate

## Prerequisites

- Java 17+
- PostgreSQL
- Maven

## Setup

1. **Clone the repository**
```bash
git clone https://github.com/woustachemax/temu-discord
cd temu-discord
```

2. **Configure Database**

Edit `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/discord_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. **Run the application**
```bash
mvn spring-boot:run
```

Server runs on `http://localhost:8080`

## API Endpoints

### REST API

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/room` | Create a new room |
| GET | `/api/v1/room/{roomId}` | Join a room |
| GET | `/api/v1/room/{roomId}/messages` | Get message history |

### WebSocket

**Connect**: `ws://localhost:8080/chat`

**Send message**: `/app/sendMessage/{roomId}`
```json
{
  "sender": "username",
  "content": "message text"
}
```

**Subscribe**: `/topic/room/{roomId}`

## Usage Example

### Create a room
```bash
curl -X POST http://localhost:8080/api/v1/room \
  -H "Content-Type: text/plain" \
  -d "general"
```

### Get messages
```bash
curl http://localhost:8080/api/v1/room/general/messages?page=0&size=20
```

## Project Structure

```
src/main/java/xyz/siddharththakkar/temu_discord/
├── controllers/       # REST and WebSocket controllers
├── entities/          # JPA entities (Room, Message)
├── repositories/      # Database repositories
├── Services/          # Business logic
├── payload/           # Request/Response DTOs
└── config/            # WebSocket configuration
```
