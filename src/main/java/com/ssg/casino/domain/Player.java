package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.CanNotLeaveTheGameException;

public class Player {
    public boolean isInGame;

    public void enter(Game game) {
        isInGame = true;
    }

    public void leave() throws CanNotLeaveTheGameException {
        if (isInGame) {
            isInGame = false;
            return;
        }

        throw new CanNotLeaveTheGameException();
    }
}
