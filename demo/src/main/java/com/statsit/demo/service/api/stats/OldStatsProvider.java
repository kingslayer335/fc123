package com.statsit.demo.service.api.stats;

import com.statsit.demo.config.ApiCfg;
import com.statsit.demo.model.api.PlayerOldApi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OldStatsProvider implements StatsProvider {

    private final WebClient webClient;
    private final ApiCfg apiCfg;

    @Override
    public Mono<List<?>> getStats(String playerId) {
        return webClient.get()
                .uri("https://open.faceit.com/data/v4/players/" + playerId + "/games/cs2/stats?limit=10")
                .header("Authorization", "Bearer " + apiCfg.getApiKey())
                .retrieve()
                .onStatus(HttpStatusCode::isError, response -> response.bodyToMono(String.class)
                        .flatMap(body -> Mono.error(
                                new RuntimeException("Old API error " + response.statusCode() + ": " + body))))
                .bodyToMono(PlayerOldApi.class)
                .map(resp -> resp.getItems()
                        .stream()
                        .map(PlayerOldApi.Item::getStats)
                        .collect(Collectors.toList()));
    }
}
