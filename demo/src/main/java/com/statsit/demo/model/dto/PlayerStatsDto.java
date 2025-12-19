package com.statsit.demo.model.dto;

import java.time.Instant;

public record PlayerStatsDto(

        Integer kills,
        Integer deaths,
        Integer assists,
        Integer headshots,
        Integer rounds,
        Integer headshotsPercent,
        Integer doubleKills,
        Integer tripleKills,
        Integer quadroKills,
        Integer pentaKills,
        Integer mvps,
        Integer secondHalfScore,
        Integer firstHalfScore,
        Integer win,
        Integer elo,
        Integer eloDelta,

        Double adr,
        Double kdRatio,
        Double krRatio,

        String map,
        String gameMode,
        String region,
        String team,
        String matchId,
        String competitionId,
        String game,
        String nickname,
        String whenFinished,
        String result,

        Instant updatedAt
) {

}
