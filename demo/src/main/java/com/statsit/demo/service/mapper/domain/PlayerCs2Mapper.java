package com.statsit.demo.service.mapper.domain;

import com.statsit.demo.model.api.PlayerCs2;
import com.statsit.demo.model.domain.PlayerCs2Domain;
import com.statsit.demo.service.mapper.common.CommonMapper;

import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = CommonMapper.class)
public interface PlayerCs2Mapper {
    @Mapping(source = "lifetime.averageKdRatio", target = "averageKdRatio", qualifiedByName = "stringToDouble")
    @Mapping(source = "lifetime.matches", target = "matches")
    @Mapping(source = "lifetime.wins", target = "wins")
    @Mapping(source = "lifetime.recentResults", target = "recentResults")
    @Mapping(source = "lifetime.averageHeadshots", target = "averageHeadshots")
    @Mapping(source = "lifetime.winRate", target = "winRate")
    @Mapping(source = "lifetime.longestWinStreak", target = "longestWinStreak")
    @Mapping(source = "lifetime.currentWinStreak", target = "currentWinStreak")
    PlayerCs2Domain toDomain(PlayerCs2 api);
}