package com.statsit.demo.model.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
public class PlayerOldStats {

    private List<Item> items;

    @Data
    public static class Item {
        private Stats stats;
    }

    @Data
    public static class Stats {
        @JsonAlias("MVPs")
        private Integer mvps;

        @JsonAlias("Rounds")
        private Integer rounds;

        @JsonAlias("Deaths")
        private Integer deaths;

        @JsonAlias("Kills")
        private Integer kills;

        @JsonAlias("Result")
        private Integer win;

        @JsonAlias("Second Half Score")
        private Integer secondHalfScore;

        @JsonAlias("Double Kills")
        private Integer doubleKills;

        @JsonAlias("Triple Kills")
        private Integer tripleKills;

        @JsonAlias("Quadro Kills")
        private Integer quadroKills;

        @JsonAlias("Penta Kills")
        private Integer pentaKills;

        @JsonAlias("Headshots")
        private Integer headshots;

        @JsonAlias("First Half Score")
        private Integer firstHalfScore;

        @JsonAlias("Assists")
        private Integer assists;

        @JsonAlias("Headshots %")
        private Integer headshotsPercent;


        @JsonAlias("K/D Ratio")
        private String kdRatio;

        @JsonAlias("Nickname")
        private String nickname;

        @JsonAlias("K/R Ratio")
        private String krRatio;

        @JsonAlias("Score")
        private String score;

        @JsonAlias("Team")
        private String team;

        @JsonAlias("Game")
        private String game;

        @JsonAlias("ADR")
        private String adr;

        @JsonAlias("Game Mode")
        private String gameMode;

        @JsonAlias("Map")
        private String map;

        @JsonAlias("Region")
        private String region;

        @JsonAlias("Player Id")
        private String playerId;

        @JsonAlias("Competition Id")
        private String competitionId;

        @JsonAlias("Match Id")
        private String matchId;
        

        @JsonAlias("Updated At")
        private Instant updatedAt;

        @JsonAlias("Match Finished At")
        private Long matchFinishedAt;

    }
}
