package com.statsit.demo.service.mapper.domain;

import com.statsit.demo.model.api.PlayerInfo;
import com.statsit.demo.model.domain.PlayerInfoDomain;
import com.statsit.demo.service.mapper.common.CommonMapper;

import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = CommonMapper.class)
public interface PlayerInfoMapper {
    @Mapping(source = "verified", target = "verified", qualifiedByName = "stringToBoolean")
    @Mapping(source = "memberSince", target = "memberSince", qualifiedByName = "stringToInstant")
    @Mapping(source = "games.cs2", target=".")
    PlayerInfoDomain toDomain(PlayerInfo api);

}