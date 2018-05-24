package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.CanNotAddNewPlayerToTheGameException;
import com.ssg.casino.domain.exceptions.OnlyOneGameException;

public class Base {

    protected Player newPlayer() {
        return new Player();
    }

    protected Player newPlayerInSomeNewGame() throws OnlyOneGameException, CanNotAddNewPlayerToTheGameException {
        Player player = newPlayer();
        player.enter(new Game());
        return player;
    }

    protected Player newPlayerInGame(Game game) throws OnlyOneGameException, CanNotAddNewPlayerToTheGameException {
        Player player = newPlayer();
        player.enter(game);
        return player;
    }
}
