package com.statsit.demo.model.api;

import java.util.List;

import com.statsit.demo.model.dto.PlayerCs2Dto;
import com.statsit.demo.model.dto.PlayerInfoDto;
import com.statsit.demo.model.dto.PlayerStatsDto;

public record PlayerResponse(
        PlayerInfoDto player,
        PlayerCs2Dto cs2,
        List<PlayerStatsDto> stats
) {}
