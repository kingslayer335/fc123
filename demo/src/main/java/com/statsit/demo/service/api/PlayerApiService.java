package com.statsit.demo.service.api;
import org.springframework.stereotype.Service;

import com.statsit.demo.service.api.info.PlayerInfoProvider;
import com.statsit.demo.model.api.PlayerCs2Info;
import com.statsit.demo.model.api.PlayerInfo;
import com.statsit.demo.service.api.info.PlayerCs2InfoProvider;
import com.statsit.demo.service.api.stats.FallbackStatsProvider;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerApiService {

    private final PlayerInfoProvider infoProvider;
    private final PlayerCs2InfoProvider cs2Provider;
    private final FallbackStatsProvider statsProvider;

    public Mono<PlayerInfo> getPlayerInfo(String username) {
        return infoProvider.getPlayerInfo(username);
    }

    public Mono<PlayerCs2Info> getPlayerCs2Info(String id) {
        return cs2Provider.getPlayerCs2Info(id);
    }

    public Mono<List<?>> getPlayerStats(String id) {
        return statsProvider.getStats(id);
    }
}
