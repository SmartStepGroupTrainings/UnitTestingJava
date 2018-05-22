package com.ssg.casino.domain;

import org.junit.Test;

public class PlayerShould {
    @Test
    public void increaseAmountWhenWin()  throws CasinoGameException {
        Player p = new Player();
        p.joins(new RollDiceGame());
        p.buy(1);

    }
}
