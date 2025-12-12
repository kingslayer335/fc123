package com.statsit.demo.service.api.info;

import com.statsit.demo.config.ApiCfg;
import com.statsit.demo.model.api.PlayerCs2Info;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PlayerCs2InfoProvider {

    private final WebClient webClient;
    private final ApiCfg apiCfg;

    public Mono<PlayerCs2Info> getPlayerCs2Info(String playerId) {
        return webClient.get()
            .uri("https://open.faceit.com/data/v4/players/" + playerId + "/stats/cs2")
            .header("Authorization", "Bearer " + apiCfg.getApiKey())
            .retrieve()
            .bodyToMono(PlayerCs2Info.class);
    }
}
