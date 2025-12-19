package com.statsit.demo.service.mapper.dto;

import com.statsit.demo.model.domain.PlayerInfoDomain;
import com.statsit.demo.model.dto.PlayerInfoDto;
import com.statsit.demo.service.mapper.common.CommonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CommonMapper.class)
public interface   PlayerInfoDtoMapper {
    PlayerInfoDto toDto(PlayerInfoDomain infoDomain);

}