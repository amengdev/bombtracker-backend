package io.github.amengdev.bombtracker_backend;

import java.time.Duration;

public class BombDurations {
    public static Duration of(String type) {
        if (type.equals("Profession Speed")) {
            return Duration.ofMinutes(10);
        }
        return Duration.ofMinutes(20);
    }
}
