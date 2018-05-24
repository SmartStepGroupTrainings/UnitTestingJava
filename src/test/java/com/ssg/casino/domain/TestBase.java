package com.ssg.casino.domain;

public class TestBase {
    protected Player newPlayer() {
        return new Player();
    }

    protected Game newGame() {
        return new Game();
    }
}
