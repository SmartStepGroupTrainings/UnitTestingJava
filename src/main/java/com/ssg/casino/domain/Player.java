package com.ssg.casino.domain;

/**
 * Created by ostkav15 24.05.18
 **/
public class Player {
    public boolean isInGame = false;

    public void join(Game game) throws PlayerAlreadyInGameException {
        if (isInGame) {
            throw new PlayerAlreadyInGameException();
        }
        isInGame = true;
    }

    public void leaveGame() throws PlayerNotInGameException {
        if (!isInGame) {
            throw new PlayerNotInGameException();
        }
        isInGame = false;
    }
}
