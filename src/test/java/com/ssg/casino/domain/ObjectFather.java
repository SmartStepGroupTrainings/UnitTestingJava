package com.ssg.casino.domain;

/**
 * Created by ostkav15 23.05.18
 **/
public class ObjectFather {
    public GameBuilder game() {
        return new GameBuilder();
    }

    public PlayerBuilder activePlayer(RollDiceGame winGame) {
        return new PlayerBuilder(winGame);
    }
}
