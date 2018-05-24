package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.CanNotLeaveTheGameException;
import com.ssg.casino.domain.exceptions.OnlyOneGameException;

public class Player {
    public boolean isInGame;

    public void enter(Game game) throws OnlyOneGameException {
        if (isInGame) {
            throw new OnlyOneGameException();
        }
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
