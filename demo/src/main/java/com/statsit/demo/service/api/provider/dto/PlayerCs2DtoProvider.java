package com.statsit.demo.service.api.provider.dto;

import com.statsit.demo.model.domain.PlayerCs2Domain;
import com.statsit.demo.model.dto.PlayerCs2Dto;
import com.statsit.demo.service.mapper.dto.PlayerCs2DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.statsit.demo.service.api.provider.domain.PlayerCs2DomainProvider;


@Component
@RequiredArgsConstructor
public class PlayerCs2DtoProvider {
    private final PlayerCs2DomainProvider domainProvider;
    private final PlayerCs2DtoMapper mapper;

    public PlayerCs2Dto getPlayerCs2(String playerId) {
        PlayerCs2Domain cs2 = domainProvider.getPlayerCs2Info(playerId);
        return mapper.toDto(cs2);

    }

}
