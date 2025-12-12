package com.statsit.demo.service.db.persistence;
import com.statsit.demo.model.entity.Player;
import com.statsit.demo.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class PlayerPersistenceService {

    private final PlayerRepository playerRepository;

    public Player saveOrUpdate(Player player) {
        return playerRepository.save(player);
    }
    public Optional<Player> findByPlayerId(String playerId) {
        return playerRepository.findByNickname(playerId);
    }

}