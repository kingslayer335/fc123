// package com.statsit.demo.service.mapper;
// import com.statsit.demo.model.api.PlayerInfo;
// import com.statsit.demo.model.dto.PlayerDbDto;
// import com.statsit.demo.model.entity.PlayerDbEntity;
//
// public class PlayerDbMapper {
//
//     public static void mapInfo(PlayerInfo info, PlayerDbEntity entity) {
//
//         entity.setPlayerId(info.getPlayerId());
//         entity.setNickname(info.getNickname());
//         entity.setAvatar(info.getAvatar());
//         entity.setCountry(info.getCountry());
//         entity.setCoverImage(info.getCoverImage());
//         entity.setMemberSince(info.getMemberSince());
//
//         if (info.getGames() != null && info.getGames().getCs2() != null) {
//             var cs2 = info.getGames().getCs2();
//
//             entity.setElo(Integer.parseInt(cs2.getElo()));
//             entity.setLevel(cs2.getLevel());
//             entity.setRegion(cs2.getRegion());
//             entity.setLevelurl(cs2.getLevelUrl());
//         }
//     }
//
//     public static PlayerDbDto toDto(PlayerDbEntity entity) {
//         return new PlayerDbDto(
//             entity.getNickname(),
//             entity.getElo(),
//             entity.getLevel(),
//             entity.getAvatar(),
//             entity.getCountry(),
//             entity.getCoverImage(),
//             entity.getMemberSince(),
//             entity.getRegion(),
//             entity.getLevelurl(),
//             entity.getWin(),
//             entity.getKills(),
//             entity.getDeaths(),
//             entity.getAssists(),
//             entity.getKdRatio(),
//             entity.getHeadshotsPercent(),
//             entity.getAdr(),
//             entity.getMap(),
//             entity.getScore(),
//             entity.getMatchFinishedAt(),
//             entity.getEloDelta()
//         );
//     }
// }
