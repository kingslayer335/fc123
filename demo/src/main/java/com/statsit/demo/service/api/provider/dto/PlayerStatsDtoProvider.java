package com.statsit.demo.service.api.provider.dto;


import com.statsit.demo.model.domain.PlayerNewStatsDomain;
import com.statsit.demo.model.domain.PlayerOldStatsDomain;
import com.statsit.demo.model.dto.PlayerStatsDto;
import com.statsit.demo.service.api.provider.domain.PlayerNewStatsDomainProvider;
import com.statsit.demo.service.api.provider.domain.PlayerOldStatsDomainProvider;
import com.statsit.demo.service.mapper.dto.PlayerStatsDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PlayerStatsDtoProvider {

    private final PlayerOldStatsDomainProvider oldStatsProvider;
    private final PlayerNewStatsDomainProvider newStatsProvider;
    private final PlayerStatsDtoMapper mapper;

    public List<PlayerStatsDto> getPlayerStats(String playerId) {

        List<PlayerOldStatsDomain> oldStats =
                oldStatsProvider.getPlayerOldStats(playerId);

        List<PlayerNewStatsDomain> newStats =
                newStatsProvider.getPlayerNewStats(playerId);

        Map<String, PlayerNewStatsDomain> newStatsByMatchId =
                newStats.stream()
                        .filter(ns -> ns.matchId() != null)
                        .collect(Collectors.toMap(
                                PlayerNewStatsDomain::matchId,
                                Function.identity(),
                                (a, b) -> a
                        ));

        return oldStats.stream()
                .map(old -> mapper.toDto(
                        old,
                        newStatsByMatchId.get(old.matchId())
                ))
                .toList();
    }
}