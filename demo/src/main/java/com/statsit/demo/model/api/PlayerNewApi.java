package com.statsit.demo.model.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.time.Instant;
import java.time.ZoneId;

@Data
public class PlayerNewApi {

    private int start;
    private int end;

    @JsonAlias("i10")
    private String win;

    public boolean isWin() {
        return win.equals("1");
    }

    @JsonAlias("i6")
    private String kills;

    @JsonAlias("i8")
    private String deaths;

    @JsonAlias("i7")
    private String assists;

    @JsonAlias("c2")
    private String kdRatio;

    @JsonAlias("c4")
    private String headshotsPercent;

    @JsonAlias("c10")
    private String adr;

    @JsonAlias("i1")
    private String map;

    @JsonAlias("i18")
    private String score;

    @JsonAlias("created_at")
    private long matchFinishedAt;

    @JsonAlias("elo")
    private String elo;

    @JsonAlias("elo_delta")
    private int eloDelta;

    public String getEloDelta() {
        return isWin() ? "+" + eloDelta : String.valueOf(eloDelta);
    }

    public String getScore() {
        String[] parts = score.split(" / ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);

        boolean leftShouldBeHigher = isWin();

        int left = leftShouldBeHigher ? Math.max(a, b) : Math.min(a, b);
        int right = leftShouldBeHigher ? Math.min(a, b) : Math.max(a, b);

        return left + " - " + right;
    }

    private Instant getCreatedInstant() {
        return Instant.ofEpochMilli(matchFinishedAt);
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
