package com.statsit.demo.service.api.provider.domain;

import com.statsit.demo.client.faceit.FaceitApiClient;
import com.statsit.demo.model.api.PlayerNewStats;
import com.statsit.demo.model.domain.PlayerNewStatsDomain;
import com.statsit.demo.service.mapper.domain.PlayerNewStatsMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import java.util.List;

import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlayerNewStatsDomainProvider {

    private final FaceitApiClient faceitApiClient;
    private final PlayerNewStatsMapper mapper;

    public List<PlayerNewStatsDomain> getPlayerNewStats(String playerId) {
        try {
            return Optional.ofNullable(
                            faceitApiClient.getPlayerNewStats(playerId, 20)
                    )
                    .map(mapper::toDomainList)
                    .orElse(List.of());

        } catch (HttpStatusCodeException e) {
            return List.of();

        } catch (RuntimeException e) {
            return List.of();
        }
    }
}