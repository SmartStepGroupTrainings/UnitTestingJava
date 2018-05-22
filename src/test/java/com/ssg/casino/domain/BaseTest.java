package com.ssg.casino.domain;

/**
 * Created by ostkav15 22.05.18
 **/
public abstract class BaseTest {

    protected Player newPlayer() {
        return new Player();
    }

    protected RollDiceGame newRollDiceGame() {
        return  new RollDiceGame();
    }

    protected Player newActivePlayer() throws CasinoGameException {
        Player newPlayer = newPlayer();
        newPlayer.joins(newRollDiceGame());
        return newPlayer;
    }

    protected Bet newBetByAmount(int amount) {
        return new Bet(amount, 5);
    }
}
