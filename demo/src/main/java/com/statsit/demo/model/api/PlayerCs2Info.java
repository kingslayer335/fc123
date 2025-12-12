package com.statsit.demo.model.api;
import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonAlias;

@Data
public class PlayerCs2Info {
    private Lifetime lifetime;
    @Data
     public static class Lifetime {
        @JsonAlias("Average K/D Ratio")
        private String averageKdRatio;
        @JsonAlias("Matches")
        private int matches;
        @JsonAlias("Wins")
        private int wins;
        @JsonAlias("Recent Results")
        private List<Integer> recentResults;
        public int getLoses() {
            return matches - wins;
        }
        @JsonAlias("Average Headshots %")
        private int averageHeadshots;
        @JsonAlias("Win Rate %")
        private int winRate;
        @JsonAlias("Longest Win Streak")
        private int longestWinStreak;
         @JsonAlias("Current Win Streak")
        private int currentWinStreak;
   }
}