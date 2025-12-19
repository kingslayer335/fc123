package com.statsit.demo.service.mapper.dto;

import com.statsit.demo.service.mapper.common.CommonMapper;
import org.mapstruct.*;
import com.statsit.demo.model.domain.PlayerNewStatsDomain;
import com.statsit.demo.model.domain.PlayerOldStatsDomain;
import com.statsit.demo.model.dto.PlayerStatsDto;

@Mapper(componentModel = "spring", uses = CommonMapper.class)
public interface PlayerStatsDtoMapper {

    @Mapping(target = "matchId", source = "newStats.matchId")
    @Mapping(target = "elo", source = "newStats.elo")
    @Mapping(target = "eloDelta", source = "newStats.eloDelta")
    PlayerStatsDto toDto( PlayerOldStatsDomain oldStats, PlayerNewStatsDomain newStats);


}
