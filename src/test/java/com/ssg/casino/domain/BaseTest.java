package com.ssg.casino.domain;

public class BaseTest {
    protected Player newPlayer() {
        return new Player();
    }

    protected RollDiceGame newRollDiceGame() {
        return new RollDiceGame();
    }

    protected Player activePlayer() throws CasinoGameException {
        Player player = newPlayer();
        player.joins(newRollDiceGame());

        return player;
    }
}
