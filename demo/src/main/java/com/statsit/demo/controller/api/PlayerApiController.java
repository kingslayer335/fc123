package com.statsit.demo.controller.api;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import reactor.core.publisher.Mono;
import java.util.List;
import com.statsit.demo.model.api.PlayerCs2Info;
import com.statsit.demo.model.api.PlayerInfo;
import com.statsit.demo.service.api.PlayerApiService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerApiController {

    private final PlayerApiService playerService;

    public PlayerApiController(PlayerApiService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/api/player")
    public Mono<Map<String, Object>> getPlayerInfo(@RequestParam String username) {

        // 1) Najpierw pobierz dane podstawowe gracza
        Mono<PlayerInfo> playerMono = playerService.getPlayerInfo(username);

        // 2) Gdy będziemy mieć PlayerInfo → równolegle pobierz stats i last games
        return playerMono.flatMap(player -> {

            Mono<PlayerCs2Info> cs2Info = playerService.getPlayerCs2Info(player.getPlayerId());
            Mono<List<?>> playerStats = playerService.getPlayerStats(player.getPlayerId());

            // 3) Połącz wszystkie 3 wyniki równolegle
            return Mono.zip(cs2Info, playerStats)
                    .map(tuple -> Map.of(
                            "player", player,
                            "playerCs2", tuple.getT1(),
                            "playerStats", tuple.getT2()));
        });
    }
}