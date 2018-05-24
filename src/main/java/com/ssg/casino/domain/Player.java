package com.ssg.casino.domain;

public class Player {
    public boolean isInGame = false;

    public void enter(Game game) throws PlayerIsInGameException {
        if (isInGame)
            throw new PlayerIsInGameException();
        isInGame = true;

    }

    public void exit() throws PlayerIsNotInGameException {
        if (isInGame) {
            isInGame = false;
            return;
        }
        throw new PlayerIsNotInGameException();
    }

    public void buy(int i) {

    }

    public int getChips() {
        return 1;
    }
}
