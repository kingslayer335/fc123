package com.statsit.demo.model.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

@Data
public class PlayerOldApi {

    private List<Item> items;
    private int start;
    private int end;

    @Data
    public static class Item {
        private Stats stats;
    }

    @Data
    public static class Stats {
        private String elo="";
        private String eloDelta="";
        @JsonAlias("MVPs")
        private String mvps;

        @JsonAlias("Match Round")
        private String matchRound;

        @JsonAlias("Overtime score")
        private String overtimeScore;

        @JsonAlias("Final Score")
        private String finalScore;

        @JsonAlias("Headshots %")
        private String headshotsPercent;

        @JsonAlias("Nickname")
        private String nickname;

        @JsonAlias("K/R Ratio")
        private String krRatio;

        @JsonAlias("Created At")
        private String createdAt;

        @JsonAlias("Score")
        private String score;

        @JsonAlias("Rounds")
        private String rounds;

        @JsonAlias("Penta Kills")
        private String pentaKills;

        @JsonAlias("Deaths")
        private String deaths;

        @JsonAlias("Triple Kills")
        private String tripleKills;

        @JsonAlias("Result")
        private String result;

        @JsonAlias("Winner")
        private String winner;

        @JsonAlias("Updated At")
        private String updatedAt;

        @JsonAlias("Kills")
        private int kills;

        @JsonAlias("K/D Ratio")
        private String kdRatio;

        @JsonAlias("First Half Score")
        private String firstHalfScore;

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

        @JsonAlias("Match Id")
        private String matchId;

        @JsonAlias("Second Half Score")
        private String secondHalfScore;

        @JsonAlias("Double Kills")
        private String doubleKills;

        @JsonAlias("Region")
        private String region;

        @JsonAlias("Player Id")
        private String playerId;

        @JsonAlias("Assists")
        private String assists;

        @JsonAlias("Best Of")
        private String bestOf;

        @JsonAlias("Competition Id")
        private String competitionId;

        @JsonAlias("Quadro Kills")
        private String quadroKills;

        @JsonAlias("Headshots")
        private String headshots;

        @JsonAlias("Match Finished At")
        private long matchFinishedAt;

        public boolean isWin() {
            return "1".equals(result);
        }

        public String getScore() {
            String[] parts = score.split(" / ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);

            // jeśli wygrana – większa liczba ma być po lewej
            // jeśli przegrana – mniejsza liczba ma być po lewej
            boolean leftShouldBeHigher = isWin();

            int left = leftShouldBeHigher ? Math.max(a, b) : Math.min(a, b);
            int right = leftShouldBeHigher ? Math.min(a, b) : Math.max(a, b);

            return left + " - " + right;
        }

        private Instant getCreatedInstant() {
            return Instant.parse(createdAt).plusSeconds(3600);
        }

        private String pluralEn(long value, String singular, String plural) {
            return value == 1 ? singular : plural;
        }

        public String getTime() {
            return getCreatedInstant()
                    .atZone(ZoneId.of("UTC"))
                    .toLocalTime()
                    .withNano(0)
                    .toString();
        }

        public String getDate() {
            return getCreatedInstant()
                    .atZone(ZoneId.of("UTC"))
                    .toLocalDate()
                    .toString();
        }

        public String getWhenFinished() {
            long finishedMillis = matchFinishedAt;
            long now = System.currentTimeMillis();
            long diff = now - finishedMillis;

            if (diff < 0)
                return "just now";

            long seconds = diff / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;

            if (days > 0) {
                return days + " " + pluralEn(days, "day", "days");
            }
            if (hours > 0) {
                return hours + " " + pluralEn(hours, "hour", "hours");
            }
            if (minutes > 0) {
                return minutes + " " + pluralEn(minutes, "min", "mins");
            }

            return "just now";
        }

    }
}
