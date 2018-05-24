package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.CanNotAddNewPlayerToTheGameException;
import com.ssg.casino.domain.exceptions.CanNotLeaveTheGameException;
import com.ssg.casino.domain.exceptions.OnlyOneGameException;

public class Player {
    public boolean isInGame;
    public int chips;
    public Bet bet;

    public void enter(Game game) throws OnlyOneGameException, CanNotAddNewPlayerToTheGameException {
        if (isInGame) {
            throw new OnlyOneGameException();
        }
        isInGame = true;
        if (game.playerCount + 1 > 6) {
            throw new CanNotAddNewPlayerToTheGameException();
        }
        game.playerCount++;
    }

    public void leave() throws CanNotLeaveTheGameException {
        if (isInGame) {
            isInGame = false;
            return;
        }

        throw new CanNotLeaveTheGameException();
    }

    public void buyChips(int chips) {
        this.chips = chips;
    }
}
