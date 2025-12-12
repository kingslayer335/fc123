package com.statsit.demo.service.api.stats;

import com.statsit.demo.config.ApiCfg;
import com.statsit.demo.model.api.PlayerNewApi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.List;

@Component
@RequiredArgsConstructor
public class NewStatsProvider implements StatsProvider {

    private final WebClient webClient;
    private final ApiCfg apiCfg;

    @Override
    public Mono<List<?>> getStats(String playerId) {
        return webClient.get()
            .uri("https://www.faceit.com/api/stats/v1/stats/time/users/" + playerId
                    + "/games/cs2?size=20&game_mode=5v5")
            .header("Authorization", "Bearer " + apiCfg.getApiKey())
            .retrieve()
            .onStatus(HttpStatusCode::isError, response ->
                response.bodyToMono(String.class)
                    .flatMap(body -> Mono.error(
                        new RuntimeException("New API error " + response.statusCode() + ": " + body)
                    ))
            )
            .bodyToFlux(PlayerNewApi.class)
            .collectList()
            .map(list -> (List<?>) list);
    }
}
