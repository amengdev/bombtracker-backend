package io.github.amengdev.bombtracker_backend;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BombController {
    private static final Logger log = LoggerFactory.getLogger(BombController.class);

    @PostMapping("/bombs")
    public ResponseEntity<Void> report(@Valid @RequestBody BombReport report) {
        log.info("Received bomb: {}", report);
        return ResponseEntity.accepted().build();
    }
}