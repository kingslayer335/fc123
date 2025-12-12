package com.statsit.demo.service.db.mapper;
import com.statsit.demo.model.api.PlayerInfo;
import com.statsit.demo.model.dto.PlayerDto;
import com.statsit.demo.model.entity.Player;

public class PlayerMapper {

    public static void mapInfo(PlayerInfo info, Player entity) {

        entity.setPlayerId(info.getPlayerId());
        entity.setNickname(info.getNickname());
        entity.setAvatar(info.getAvatar());
        entity.setCountry(info.getCountry());
        entity.setCoverImage(info.getCoverImage());
        entity.setMemberSince(info.getMemberSince());

        if (info.getGames() != null && info.getGames().getCs2() != null) {
            var cs2 = info.getGames().getCs2();

            entity.setElo(Integer.parseInt(cs2.getElo()));
            entity.setLevel(cs2.getLevel());
            entity.setRegion(cs2.getRegion());
            entity.setLevelurl(cs2.getLevelUrl());
        }
    }

    public static PlayerDto toDto(Player entity) {
        return new PlayerDto(
            entity.getNickname(),
            entity.getElo(),
            entity.getLevel(),
            entity.getAvatar(),
            entity.getCountry(),
            entity.getCoverImage(),
            entity.getMemberSince(),
            entity.getRegion(),
            entity.getLevelurl(),
            entity.getWin(),
            entity.getKills(),
            entity.getDeaths(),
            entity.getAssists(),
            entity.getKdRatio(),
            entity.getHeadshotsPercent(),
            entity.getAdr(),
            entity.getMap(),
            entity.getScore(),
            entity.getMatchFinishedAt(),
            entity.getEloDelta()
        );
    }
}
