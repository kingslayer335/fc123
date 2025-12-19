package com.statsit.demo.service.api;

import com.statsit.demo.model.dto.PlayerCs2Dto;
import com.statsit.demo.model.dto.PlayerInfoDto;
import com.statsit.demo.model.dto.PlayerStatsDto;
import com.statsit.demo.service.api.provider.dto.PlayerCs2DtoProvider;
import com.statsit.demo.service.api.provider.dto.PlayerInfoDtoProvider;
import com.statsit.demo.service.api.provider.dto.PlayerStatsDtoProvider;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerApiService {

    private final PlayerInfoDtoProvider infoProvider;
    private final PlayerStatsDtoProvider statsDtoProvider;
    private final PlayerCs2DtoProvider cs2DtoProvider;

    public PlayerInfoDto getPlayerInfo(String username) {
        return infoProvider.getPlayerInfo(username);
    }

    public PlayerCs2Dto getPlayerCs2(String playerId) {
        return cs2DtoProvider.getPlayerCs2(playerId);
    }

    public List<PlayerStatsDto> getPlayerStats(String playerId) {
        return statsDtoProvider.getPlayerStats(playerId);
    }
}
