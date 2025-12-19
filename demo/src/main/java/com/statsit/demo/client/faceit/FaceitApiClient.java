package com.statsit.demo.client.faceit;

import com.statsit.demo.config.FaceitApiProperties;
import com.statsit.demo.model.api.PlayerCs2;
import com.statsit.demo.model.api.PlayerInfo;
import com.statsit.demo.model.api.PlayerNewStats;
import com.statsit.demo.model.api.PlayerOldStats;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FaceitApiClient {
    //newStats nie potrzebuje apikeya to robie osobny resttemplate bez autoryazcji
    //dalem normalny konstruktor bo jak uzywam @RequiredArgsConstructor to nie czyta @Qualifier

    private final RestTemplate noAuthRestTemplate;
    private final RestTemplate authRestTemplate;
    private final FaceitApiProperties properties;

    public FaceitApiClient(@Qualifier("faceitAuth") RestTemplate authRestTemplate, @Qualifier("faceitNoAuth") RestTemplate noAuthRestTemplate, FaceitApiProperties properties) {
        this.authRestTemplate = authRestTemplate;
        this.noAuthRestTemplate = noAuthRestTemplate;
        this.properties = properties;
    }

    public PlayerInfo getPlayerInfo(String username) {
        return authRestTemplate.getForObject(
                properties.openBaseUrl() + FaceitEndpoints.PLAYER_INFO,
                PlayerInfo.class,
                username
        );
    }

    public PlayerCs2 getPlayerCs2(String playerId) {
        return authRestTemplate.getForObject(
                properties.openBaseUrl() + FaceitEndpoints.PLAYER_CS2,
                PlayerCs2.class,
                playerId
        );
    }

    public List<PlayerNewStats> getPlayerNewStats(String playerId, int size) {
        ResponseEntity<List<PlayerNewStats>> response =
                noAuthRestTemplate.exchange(
                        properties.statsBaseUrl()
                                + FaceitEndpoints.PLAYER_NEW_STATS,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        },
                        playerId,
                        size
                );

        return response.getBody();
    }


    public PlayerOldStats getPlayerOldStats(String playerId, int limit) {
        return authRestTemplate.getForObject(
                properties.openBaseUrl() + FaceitEndpoints.PLAYER_OLD_STATS,
                PlayerOldStats.class,
                playerId,
                limit
        );
    }

}