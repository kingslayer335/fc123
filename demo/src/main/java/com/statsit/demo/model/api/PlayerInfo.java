package com.statsit.demo.model.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.util.List;

@Data
public class PlayerInfo {

    @JsonAlias("player_id")
    private String playerId;
    private String nickname;
    private String avatar;
    private String country;
    private String coverImage;
    @JsonAlias("steam_id_64")
    private String steamId64;
    @JsonAlias("faceit_url")
    private String faceitUrl;
    private String verified;
    @JsonAlias("activated_at")
    private String memberSince;

    @JsonAlias("memberships")
    private List<String> memberships;

    private Games games;

    @Data
    public static class Games {
        private Cs2 cs2;

        @Data
        public static class Cs2 {
            @JsonAlias("faceit_elo")
            private Integer elo;
            @JsonAlias("skill_level")
            private Integer level;

            private String region;
        }
    }
}