package com.statsit.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.statsit.demo.model.entity.Player;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByNickname(String nickname);
}