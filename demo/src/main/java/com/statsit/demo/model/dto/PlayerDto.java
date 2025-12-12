package com.statsit.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    private String nickname;
    private int elo;
    private int level;
    private String avatar;
    private String country;
    private String coverImage;
    private String memberSince;
    private String region;
    private String levelurl;
    private String win;
    private String kills;
    private String deaths;
    private String assists;
    private String kdRatio;
    private String headshotsPercent;
    private String adr;
    private String map;
    private String score;
    private long matchFinishedAt;
    private String eloDelta;
}
