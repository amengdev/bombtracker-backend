package io.github.amengdev.bombtracker_backend;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class BombController {
    private static final Logger log = LoggerFactory.getLogger(BombController.class);
    private final BombRepository repository;

    public BombController(BombRepository repository){
        this.repository = repository;
    }

    @PostMapping("/bombs")
    public ResponseEntity<Void> report(@Valid @RequestBody BombReport report) {
        Bomb saved = repository.save(new Bomb(report.player(), report.type(), report.server(), Instant.now()));
        log.info("Received bomb #{}: {}", saved.getId(), report);
        return ResponseEntity.accepted().build();
    }
}