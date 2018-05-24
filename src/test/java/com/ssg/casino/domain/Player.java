package com.ssg.casino.domain;

public class Player {
    public boolean isInGame = true;

    public void enter(Game game) {

    }

    public void exit() {
        isInGame = false;
    }
}
