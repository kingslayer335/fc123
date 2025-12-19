package com.statsit.demo.service.api.provider.domain;

import com.statsit.demo.client.faceit.FaceitApiClient;
import com.statsit.demo.model.api.PlayerCs2;
import com.statsit.demo.model.domain.PlayerCs2Domain;
import com.statsit.demo.service.mapper.domain.PlayerCs2Mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerCs2DomainProvider {
    private final FaceitApiClient faceitClient;
    private final PlayerCs2Mapper mapper;

    public PlayerCs2Domain getPlayerCs2Info(String playerId) {
        PlayerCs2 response = faceitClient.getPlayerCs2(playerId);

        if (response == null) {
            throw new RuntimeException("Faceit Info Api returned null");
        }
        return mapper.toDomain(response);
    }
}
