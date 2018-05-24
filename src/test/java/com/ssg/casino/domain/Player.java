package com.ssg.casino.domain;

public class Player {
    public boolean isInGame = true;

    public void enter(Game game) {
    }

    public void leave() {
        isInGame = false;
    }
}
