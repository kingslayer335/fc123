package com.statsit.demo.client.faceit;

public final class FaceitEndpoints {

    private FaceitEndpoints() {}

    public static final String PLAYER_INFO =
            "/players?nickname={username}";

    public static final String PLAYER_CS2 =
            "/players/{playerId}/stats/cs2";

    public static final String PLAYER_OLD_STATS =
            "/players/{playerId}/games/cs2/stats?limit=20";

    public static final String PLAYER_NEW_STATS =
            "{playerId}/games/cs2?size=20&game_mode=5v5";
}
