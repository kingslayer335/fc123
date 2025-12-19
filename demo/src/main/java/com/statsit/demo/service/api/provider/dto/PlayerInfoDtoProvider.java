package com.statsit.demo.service.api.provider.dto;

import com.statsit.demo.model.domain.PlayerInfoDomain;
import com.statsit.demo.model.dto.PlayerInfoDto;
import com.statsit.demo.service.api.provider.domain.PlayerInfoDomainProvider;
import com.statsit.demo.service.mapper.dto.PlayerInfoDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class PlayerInfoDtoProvider {
    private final PlayerInfoDomainProvider domainProvider;
    private final PlayerInfoDtoMapper mapper;

    public PlayerInfoDto getPlayerInfo(String username) {


        PlayerInfoDomain info = domainProvider.getPlayerInfo(username);
        return mapper.toDto(info);

    }

}

