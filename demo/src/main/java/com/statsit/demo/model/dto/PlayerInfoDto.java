 package com.statsit.demo.model.dto;

 import java.util.List;
 import java.time.Instant;

 public record PlayerInfoDto(

         String playerId,
         String nickname,
         String avatar,
         String country,
         String coverImage,
         String steamId64,
         String faceitUrl,
         boolean verified,
         String region,
         int elo,
         int level,
         Instant memberSince,
         List<String> memberships

 ) {

 }
