package com.statsit.demo.model.domain;

import java.time.Instant;
import java.util.List;

public record PlayerInfoDomain(

        String playerId,
        String nickname,
        String avatar,
        String country,
        String coverImage,
        String steamId64,
        String faceitUrl,
        boolean verified,
        String region,
        int elo,
        int level,
        Instant memberSince,
        List<String> memberships


) {

}
