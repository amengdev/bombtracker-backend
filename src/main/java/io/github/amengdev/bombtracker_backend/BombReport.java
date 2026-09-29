package io.github.amengdev.bombtracker_backend;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record BombReport(
        @NotBlank @Size(max = 16) String player, // minecraft usernames have at most 16 characters
        @NotBlank @Size(max = 128) String type,
        @NotBlank @Size(max = 4) String server // server max is 4 characters
        ) {}

