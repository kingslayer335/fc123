package com.statsit.demo.model.dto;

import java.util.List;

public record PlayerCs2Dto(

        Integer matches,
        Integer wins,
        Integer averageHeadshots,
        Integer winRate,
        Integer longestWinStreak,
        Integer currentWinStreak,

        Double averageKdRatio,

        List<Integer> recentResults

) {


}
