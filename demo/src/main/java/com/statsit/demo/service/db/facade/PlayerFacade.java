// package com.statsit.demo.service.db.facade;
//
// import com.statsit.demo.model.dto.PlayerDbDto;
// import com.statsit.demo.model.entity.PlayerDbEntity;
// import com.statsit.demo.service.api.PlayerApiService;
// import com.statsit.demo.service.db.persistence.PlayerPersistenceService;
// import com.statsit.demo.service.mapper.PlayerDbMapper;
//
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import reactor.core.publisher.Mono;
//
// @Service
// @RequiredArgsConstructor
// public class PlayerFacade {
//
//     private final PlayerApiService apiService;
//     private final PlayerPersistenceService persistenceService;
//
//     public Mono<PlayerDbDto> getPlayer(String username) {
//
//         return apiService.getPlayerInfo(username)
//                 .flatMap(playerInfo -> {
//
//                     PlayerDbEntity entity = persistenceService
//                             .findByPlayerId(playerInfo.getPlayerId())
//                             .orElseGet(PlayerDbEntity::new);
//
//                     PlayerDbMapper.mapInfo(playerInfo, entity);
//                     PlayerDbEntity saved = persistenceService.saveOrUpdate(entity);
//                     return Mono.just(PlayerDbMapper.toDto(saved));
//                 });
//     }
// }
