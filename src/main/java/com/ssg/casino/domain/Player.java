package com.ssg.casino.domain;

public class Player {
    public boolean isInGame = false;

    public void enter(Game game) throws PlayerIsInGame {
        if (isInGame)
            throw new PlayerIsInGame();
        isInGame = true;

    }

    public void exit() throws PlayerIsNotInGame {
        if (isInGame) {
            isInGame = false;
            return;
        }
        throw new PlayerIsNotInGame();
    }
}
