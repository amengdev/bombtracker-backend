package io.github.amengdev.bombtracker_backend;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "bombs")
public class Bomb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 16)
    private String player;

    @Column(nullable = false, length = 128)
    private String type;

    @Column(nullable = false, length = 4)
    private String server;

    @Column(nullable = false)
    private Instant receivedAt;

    @Column(nullable = false)
    private Instant expiresAt;

    protected Bomb() {}

    public Bomb(String player, String type, String server, Instant receivedAt, Instant expiresAt) {
        this.player = player;
        this.type = type;
        this.server = server;
        this.receivedAt = receivedAt;
        this.expiresAt = expiresAt;
    }

    public long getId() {
        return id;
    }
    public String getPlayer() {
        return player;
    }
    public String getType() {
        return type;
    }
    public String getServer() {
        return server;
    }
    public Instant getReceivedAt() {
        return receivedAt;
    }
    public Instant getExpiresAt() {
        return expiresAt;
    }
}
