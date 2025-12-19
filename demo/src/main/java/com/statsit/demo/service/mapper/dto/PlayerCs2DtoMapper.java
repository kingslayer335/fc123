package com.statsit.demo.service.mapper.dto;

import com.statsit.demo.model.domain.PlayerCs2Domain;
import com.statsit.demo.model.dto.PlayerCs2Dto;
import com.statsit.demo.service.mapper.common.CommonMapper;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = CommonMapper.class)
public interface PlayerCs2DtoMapper {

    PlayerCs2Dto toDto(PlayerCs2Domain cs2Domain);

}
