package com.statsit.demo.service.api.provider.domain;

import com.statsit.demo.client.faceit.FaceitApiClient;
import lombok.RequiredArgsConstructor;
import com.statsit.demo.model.api.PlayerInfo;
import com.statsit.demo.model.domain.PlayerInfoDomain;
import com.statsit.demo.service.mapper.domain.PlayerInfoMapper;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerInfoDomainProvider {

    private final FaceitApiClient faceitClient;
    private final PlayerInfoMapper mapper;

    public PlayerInfoDomain getPlayerInfo(String username) {
        PlayerInfo response = faceitClient.getPlayerInfo(username);

        if (response == null) {
            throw new RuntimeException("Faceit Info Api returned null");
        }
        return mapper.toDomain(response);
    }
}
