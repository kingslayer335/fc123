package com.statsit.demo.model.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class PlayerNewStats {

    @JsonAlias("elo")
    private Integer elo;
    @JsonAlias("elo_delta")
    private Integer eloDelta;
    @JsonAlias("matchId")
    private String matchId;

}
