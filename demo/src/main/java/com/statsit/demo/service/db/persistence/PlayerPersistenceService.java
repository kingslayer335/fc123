// package com.statsit.demo.service.db.persistence;
// import com.statsit.demo.model.entity.PlayerDbEntity;
// import com.statsit.demo.repository.PlayerRepository;
// import jakarta.transaction.Transactional;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import java.util.Optional;


// @Service
// @RequiredArgsConstructor
// @Transactional
// public class PlayerPersistenceService {

//     private final PlayerRepository playerRepository;

//     public PlayerDbEntity saveOrUpdate(PlayerDbEntity player) {
//         return playerRepository.save(player);
//     }
//     public Optional<PlayerDbEntity> findByPlayerId(String playerId) {
//         return playerRepository.findByNickname(playerId);
//     }

// }