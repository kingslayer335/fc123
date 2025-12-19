package com.statsit.demo.controller.api;

import com.statsit.demo.model.dto.PlayerStatsDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.statsit.demo.service.api.PlayerApiService;
import com.statsit.demo.model.dto.PlayerInfoDto;
import com.statsit.demo.model.dto.PlayerCs2Dto;
import com.statsit.demo.model.api.PlayerResponse;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(("/player"))
@RequiredArgsConstructor
public class PlayerApiController {

    private final PlayerApiService playerService;

    @GetMapping
    public PlayerResponse getPlayerInfo(@RequestParam String username) {
        PlayerInfoDto info = playerService.getPlayerInfo(username);
        PlayerCs2Dto cs2Stats = playerService.getPlayerCs2(info.playerId());
        List<PlayerStatsDto> matchStats = playerService.getPlayerStats(info.playerId());

        return new PlayerResponse(info, cs2Stats, matchStats);
    }
}