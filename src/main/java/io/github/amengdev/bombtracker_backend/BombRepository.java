package io.github.amengdev.bombtracker_backend;

import org.springframework.data.jpa.repository.JpaRepository;



public interface BombRepository extends JpaRepository<Bomb, Long> {
}
