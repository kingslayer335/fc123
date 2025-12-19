package com.statsit.demo.model.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Time;
import java.time.Instant;

public record PlayerOldStatsDomain(

        Integer kills,
        Integer deaths,
        Integer assists,
        Integer headshots,
        Integer rounds,
        Integer headshotsPercent,
        Integer doubleKills,
        Integer tripleKills,
        Integer quadroKills,
        Integer pentaKills,
        Integer mvps,
        Integer secondHalfScore,
        Integer firstHalfScore,
        Integer win,

        Double adr,
        Double kdRatio,
        Double krRatio,

        String map,
        String gameMode,
        String region,
        String team,
        String score,
        String matchId,
        String playerId,
        String competitionId,
        String game,
        String nickname,

        Long matchFinishedAt,

        Instant updatedAt
) {

    public Boolean isWin() {
        return win != null && win == 1;
    }

    public String getResult() {
        if (score == null) {
            return null;
        }

        String[] parts = score.split(" / ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);

        boolean leftShouldBeHigher = isWin();

        int left = leftShouldBeHigher ? Math.max(a, b) : Math.min(a, b);
        int right = leftShouldBeHigher ? Math.min(a, b) : Math.max(a, b);

        return left + " - " + right;
    }

    public String getWhenFinished() {
        return TimeUnitEnum.formattedTime(matchFinishedAt == null ? 0L : matchFinishedAt);
    }

    @Getter
    @RequiredArgsConstructor
    public enum TimeUnitEnum {
        DAY("day", "days", 1000 * 60 * 60 * 24),
        HOUR("hour", "hours", 1000 * 60 * 60),
        MINUTE("minute", "minutes", 1000 * 60);

        private final String singular;
        private final String plural;
        private final int millisecondDuration;

        private static final String JUST_NOW = "just now";

        public static String formattedTime(long matchFinishedAt) {
            final long timeDifference = System.currentTimeMillis() - matchFinishedAt;
            if (timeDifference <= TimeUnitEnum.MINUTE.millisecondDuration) {
                return TimeUnitEnum.JUST_NOW;
            }
            for (var timeUnit : values()) {
                final long timeUnitAmount = timeDifference / timeUnit.millisecondDuration;
                if (timeUnitAmount > 0) {
                    return timeUnit.getGrammaticalNumber(timeUnitAmount, timeUnit);
                }
            }
            return TimeUnitEnum.JUST_NOW;
        }

        private String getGrammaticalNumber(final long number, final TimeUnitEnum timeUnit) {
            return String.format("%d %s", number, number == 1 ? timeUnit.getSingular() : timeUnit.getPlural());
        }
    }
}

