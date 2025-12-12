package com.statsit.demo.model.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String playerId;
    private String avatar;
    private String country;
    private String coverImage;
    private String memberSince;
    private int elo;
    private int level;
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
