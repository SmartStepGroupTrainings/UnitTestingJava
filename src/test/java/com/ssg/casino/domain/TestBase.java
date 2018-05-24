package com.ssg.casino.domain;

public class TestBase {
    protected Player newPlayer() {
        return new Player();
    }

    protected Game newGame() {
        return new Game();
    }

    protected Player newPlayerInGame() throws PlayerIsInGame {
        Player player = newPlayer();
        player.enter(newGame());
        return player;
    }
}
