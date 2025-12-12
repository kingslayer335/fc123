package com.statsit.demo.model.api;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class PlayerInfo {
    @JsonAlias("player_id")
    private String playerId;
    private String nickname;   
    private String avatar;
    private String country;
    private String coverImage;
    private Games games;
    @JsonAlias("steam_id_64")
    private String steamId64;
    @JsonAlias("faceit_url")
    private String faceitUrl;
    private String verified;
    @JsonAlias("activated_at")
    private String memberSince;
    public String getMemberSince() {
        return memberSince.substring(0, 10);
    }
    public String getCountryFlag() {
        return "https://flagcdn.com/w320/" + country + ".png";
    }

    @Data
    public static class Games {
        private Cs2 cs2;
        @Data
        public static class Cs2 {
            @JsonAlias("faceit_elo")
            private String elo;
            @JsonAlias("skill_level")
            private int level;
            private String region;
            public String getLevelUrl() {
                return "/assets/images/levels/"+level+".svg";
            }
        }
    }
}