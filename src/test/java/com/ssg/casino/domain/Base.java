package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.OnlyOneGameException;

public class Base {

    protected Player newPlayer() {
        return new Player();
    }

    protected Player newPlayerInGame() throws OnlyOneGameException {
        Player player = newPlayer();
        player.enter(new Game());
        return player;
    }
}
