package com.statsit.demo.service.db.facade;

import com.statsit.demo.model.dto.PlayerDto;
import com.statsit.demo.model.entity.Player;
import com.statsit.demo.service.api.PlayerApiService;
import com.statsit.demo.service.db.mapper.PlayerMapper;
import com.statsit.demo.service.db.persistence.PlayerPersistenceService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PlayerFacade {

    private final PlayerApiService apiService;
    private final PlayerPersistenceService persistenceService;

    public Mono<PlayerDto> getPlayer(String username) {

        return apiService.getPlayerInfo(username)
                .flatMap(playerInfo -> {

                    Player entity = persistenceService
                            .findByPlayerId(playerInfo.getPlayerId())
                            .orElseGet(Player::new);

                    PlayerMapper.mapInfo(playerInfo, entity);
                    Player saved = persistenceService.saveOrUpdate(entity);
                    return Mono.just(PlayerMapper.toDto(saved));
                });
    }
}
