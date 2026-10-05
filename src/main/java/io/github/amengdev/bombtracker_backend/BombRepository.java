package io.github.amengdev.bombtracker_backend;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface BombRepository extends JpaRepository<Bomb, Long> {
    List<Bomb> findByExpiresAtAfterOrderByReceivedAtDesc(Instant now);
}
