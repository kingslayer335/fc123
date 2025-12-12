package com.statsit.demo.service.api.stats;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FallbackStatsProvider implements StatsProvider {

    private final NewStatsProvider newStatsProvider;
    private final OldStatsProvider oldStatsProvider;

    @Override
    public Mono<List<?>> getStats(String playerId) {

        return newStatsProvider.getStats(playerId)
            .flatMap(list -> {
                if (list == null || list.isEmpty()) {
                    System.out.println("New API returned EMPTY → switching to OLD API");
                    return oldStatsProvider.getStats(playerId);
                }
                return Mono.just(list);
            })
            .onErrorResume(ex -> {
                System.err.println("New API failed → switching to OLD API");
                return oldStatsProvider.getStats(playerId);
            });
    }
}
