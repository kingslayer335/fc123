package com.statsit.demo.service.api.provider.domain;

import com.statsit.demo.client.faceit.FaceitApiClient;
import com.statsit.demo.model.api.PlayerOldStats;
import com.statsit.demo.model.domain.PlayerOldStatsDomain;
import com.statsit.demo.service.mapper.domain.PlayerOldStatsMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class PlayerOldStatsDomainProvider {

    private final FaceitApiClient faceitApiClient;
    private final PlayerOldStatsMapper mapper;

    public List<PlayerOldStatsDomain> getPlayerOldStats(String playerId) {
        PlayerOldStats response =
                faceitApiClient.getPlayerOldStats(playerId, 10);

        if (response == null || response.getItems() == null) {
            throw new RuntimeException("Faceit Old API returned null");
        }

        return mapper.listToDomain(response.getItems());
    }
}
