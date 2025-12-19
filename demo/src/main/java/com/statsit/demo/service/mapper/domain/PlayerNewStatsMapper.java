package com.statsit.demo.service.mapper.domain;

import com.statsit.demo.model.api.PlayerNewStats;

import com.statsit.demo.model.domain.PlayerNewStatsDomain;
import com.statsit.demo.service.mapper.common.CommonMapper;
import java.util.List;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = CommonMapper.class)
public interface PlayerNewStatsMapper {

    PlayerNewStatsDomain toDomain(PlayerNewStats api);

    List<PlayerNewStatsDomain> toDomainList(List<PlayerNewStats> api);
}
