package com.statsit.demo.service.mapper.domain;

import com.statsit.demo.model.api.PlayerOldStats;

import com.statsit.demo.model.domain.PlayerOldStatsDomain;
import com.statsit.demo.service.mapper.common.CommonMapper;

import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring", uses = CommonMapper.class)
public interface PlayerOldStatsMapper {

    // PlayerOldApi na PlayerStatsDomain
    // ustawiam source na stats zeby nie musiec przepisywac wszystkich zmiennych
    // ktore sie niczym nie roznia wewnatrz Stats w PlayerOldApi i do tego nie musze piac 'stats.'
    @Mapping(source = "stats", target = ".", qualifiedByName = "fromStats")

    PlayerOldStatsDomain toDomain(PlayerOldStats.Item item);

    List<PlayerOldStatsDomain> listToDomain(List<PlayerOldStats.Item> items);

    @Named("fromStats")
    @Mapping(source = "krRatio", target = "krRatio", qualifiedByName = "stringToDouble")
    @Mapping(source = "kdRatio", target = "kdRatio", qualifiedByName = "stringToDouble")
    @Mapping(source = "adr", target = "adr", qualifiedByName = "stringToDouble")

    PlayerOldStatsDomain fromStats(PlayerOldStats.Stats stats);
}
