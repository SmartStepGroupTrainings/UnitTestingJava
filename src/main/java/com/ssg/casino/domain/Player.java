package com.ssg.casino.domain;

/**
 * Created by ostkav15 24.05.18
 **/
public class Player {
    public boolean isInGame = false;
    public int chipsAmount = 0;
    public int betAmount = 0;

    public void join(Game game) throws PlayerAlreadyInGameException, GameIsFullException {
        if (isInGame) {
            throw new PlayerAlreadyInGameException();
        }
        isInGame = true;
        game.accept(this);
    }

    public void leaveGame() throws PlayerNotInGameException {
        if (!isInGame) {
            throw new PlayerNotInGameException();
        }
        isInGame = false;
    }


    public void buy(int chipsAmount) {
        this.chipsAmount = chipsAmount;
    }

    public void makeBet(int betAmount) throws NotEnoughChipsException {
        if (betAmount > chipsAmount) {
            throw new NotEnoughChipsException();
        }
        this.betAmount = betAmount;
    }

    public boolean hadBet() {
        return betAmount > 0;
    }

    public boolean hasChips() {
        return chipsAmount > 0;
    }
}
