package com.statsit.demo.controller.db;

import com.statsit.demo.model.dto.PlayerDto;
import com.statsit.demo.service.db.facade.PlayerFacade;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/db/player")
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerDbController {

    private final PlayerFacade playerFacade;

    public PlayerDbController(PlayerFacade playerFacade) {
        this.playerFacade = playerFacade;
    }

    @PostMapping
    public Mono<PlayerDto> savePlayer(@RequestParam String username) {
        return playerFacade.getPlayer(username);
    }
}
