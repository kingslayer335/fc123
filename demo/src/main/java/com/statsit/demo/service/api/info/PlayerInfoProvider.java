package com.statsit.demo.service.api.info;

import com.statsit.demo.config.ApiCfg;
import com.statsit.demo.model.api.PlayerInfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PlayerInfoProvider {

    private final WebClient webClient;
    private final ApiCfg apiCfg;

    public Mono<PlayerInfo> getPlayerInfo(String username) {
        return webClient.get()
            .uri("https://open.faceit.com/data/v4/players?nickname=" + username)
            .header("Authorization", "Bearer " + apiCfg.getApiKey())
            .retrieve()
            .bodyToMono(PlayerInfo.class);
    }
}
