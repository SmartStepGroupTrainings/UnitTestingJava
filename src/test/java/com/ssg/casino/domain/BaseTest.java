package com.ssg.casino.domain;

/**
 * Created by ostkav15 24.05.18
 **/
public class BaseTest {
    protected Player newPlayerInGame() {
        Player player = newPlayer();

        player.join(new Game());
        return player;
    }

    protected Player newPlayer() {
        return new Player();
    }
}
