package com.statsit.demo.model.api;

import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonAlias;

@Data
public class PlayerCs2 {
   private Lifetime lifetime;

   @Data
   public static class Lifetime {

      @JsonAlias("Matches")
      private Integer matches;
      @JsonAlias("Wins")
      private Integer wins;
      @JsonAlias("Average Headshots %")
      private Integer averageHeadshots;
      @JsonAlias("Win Rate %")
      private Integer winRate;
      @JsonAlias("Longest Win Streak")
      private Integer longestWinStreak;
      @JsonAlias("Current Win Streak")
      private Integer currentWinStreak;

      @JsonAlias("Average K/D Ratio")
      private String averageKdRatio;

      @JsonAlias("Recent Results")
      private List<Integer> recentResults;

   }
}