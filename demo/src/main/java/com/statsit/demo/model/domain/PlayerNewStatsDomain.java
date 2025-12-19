package com.statsit.demo.model.domain;

public record PlayerNewStatsDomain(

        Integer elo,
        Integer eloDelta,

        String matchId

) {

}
