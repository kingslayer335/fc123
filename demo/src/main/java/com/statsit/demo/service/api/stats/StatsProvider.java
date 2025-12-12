package com.statsit.demo.service.api.stats;

import reactor.core.publisher.Mono;
import java.util.List;

public interface StatsProvider {
    Mono<List<?>> getStats(String playerId);
}
