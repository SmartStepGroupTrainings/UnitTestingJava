package com.ssg.casino.domain.dsl;

public class ObjectFather {

    public PlayerBuilder activePlayer() {
        return new PlayerBuilder();
    }

    public GameBuilder newGame() {
        return new GameBuilder();
    }
}
