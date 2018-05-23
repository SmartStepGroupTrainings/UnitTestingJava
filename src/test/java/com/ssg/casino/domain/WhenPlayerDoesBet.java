package com.ssg.casino.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class WhenPlayerDoesBet {
    @Test
    public void decreaseAmount() throws CasinoGameException {
        Player player = new Player();
        player.joins(new RollDiceGame());
        player.buy(10);

        player.bet(new Bet(2, 1));

        assertEquals(10 - 2, player.getAvailableChips());
    }

    @Test(expected = CasinoGameException.class)
    public void failIfPlayerBetsMoreChipsThanHeHas() throws CasinoGameException {
        Player player = new Player();
        player.joins(new RollDiceGame());
        player.buy(10);

        player.bet(new Bet(10 + 1, 1));
    }
}