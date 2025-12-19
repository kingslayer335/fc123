package com.statsit.demo.model.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public record PlayerCs2Domain(

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