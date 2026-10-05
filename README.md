# Bomb Tracker Backend

A Spring Boot REST API that receives Wynncraft bomb reports, stores them in PostgreSQL, and serves the currently active bombs.

## The Bomb Tracker system

```
bombtracker (mod)  ──POST /bombs──▶  bombtracker-backend  ◀──GET /bombs/active──  bombtracker-bot
 reads game chat                      stores bombs                                  /bombs in Discord
```

| Repo | Role | Stack |
|---|---|---|
| [bombtracker](https://github.com/amengdev/bombtracker) | Detects bombs in game chat | Java, Fabric |
| **bombtracker-backend** (this repo) | Stores bombs, serves active ones | Java, Spring Boot, PostgreSQL |
| [bombtracker-bot](https://github.com/amengdev/bombtracker-bot) | Shows active bombs in Discord | Python, discord.py |

**Stack:** Java 25, Spring Boot 4, Spring Data JPA (Hibernate), PostgreSQL, Gradle

## API

### `POST /bombs`

Reports a bomb. Sent by the mod.

```json
{ "player": "ExamplePlayer", "type": "Combat Experience", "server": "NA10" }
```

| Response | Meaning |
|---|---|
| `202 Accepted` | Bomb saved |
| `400 Bad Request` | Validation failed (missing, empty, or oversized field) |

### `GET /bombs/active`

Returns bombs that haven't expired yet, newest first. Used by the bot.

```json
[
  {
    "id": 6,
    "player": "ExamplePlayer",
    "type": "Combat Experience",
    "server": "NA25",
    "receivedAt": "2026-10-05T20:17:57.368987Z",
    "expiresAt": "2026-10-05T20:37:57.368987Z"
  }
]
```

## Running locally

Requirements: JDK 25 and PostgreSQL running on `localhost:5432`.

1. Create the database:
   ```sql
   CREATE DATABASE bombtracker;
   ```
2. Set the `DB_USER` environment variable to your Postgres username (in IntelliJ: Run → Edit Configurations → Environment variables).
3. Start the app:
   ```bash
   ./gradlew bootRun
   ```
4. Try it:
   ```bash
   curl -i -X POST localhost:8080/bombs \
     -H "Content-Type: application/json" \
     -d '{"player":"ExamplePlayer","type":"Combat Experience","server":"NA10"}'

   curl localhost:8080/bombs/active
   ```

Tables are created automatically by Hibernate (`spring.jpa.hibernate.ddl-auto=update`).

## Disclaimer

This is a fan project and is not affiliated with Wynncraft.
