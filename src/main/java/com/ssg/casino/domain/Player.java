package com.ssg.casino.domain;

/**
 * Created by ostkav15 24.05.18
 **/
public class Player {
    public boolean isInGame = false;

    public void join(Game game) {
        isInGame = true;
    }

    public void leaveGame() throws PlayerNotInGameException {
        if (isInGame) {
            isInGame = false;
            return;
        }
        throw new PlayerNotInGameException();
    }
}
