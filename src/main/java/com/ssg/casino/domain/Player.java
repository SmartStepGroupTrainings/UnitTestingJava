package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.HasMaxPlayersCountException;
import com.ssg.casino.domain.exceptions.CanNotLeaveTheGameException;
import com.ssg.casino.domain.exceptions.NotEnoughChipsException;
import com.ssg.casino.domain.exceptions.OnlyOneGameException;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public boolean isInGame;
    public int chips;
    public List<Bet> bets = new ArrayList<>();

    public void enter(Game game) throws OnlyOneGameException, HasMaxPlayersCountException {
        if (isInGame) {
            throw new OnlyOneGameException();
        }
        isInGame = true;
        if (game.playerCount + 1 > 6) {
            throw new HasMaxPlayersCountException();
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

    public void doBet(Bet bet) throws NotEnoughChipsException {

        if (bet.amount > chips) {
            throw new NotEnoughChipsException();
        }

        this.bets.add(bet);
    }
}
