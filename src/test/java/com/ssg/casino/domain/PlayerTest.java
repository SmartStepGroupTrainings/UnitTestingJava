package com.ssg.casino.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void leave() throws CasinoGameException {
        Player p = new Player();

        assertNull(p.activeGame());
        p.joins(new RollDiceGame());
        assertNotNull(p.activeGame());

        p.leave();
        assertNull(p.activeGame());

    }

    @Test
    public void bet() throws CasinoGameException {
        Player p = new Player();

        p.joins(new RollDiceGame());
        p.buy(99999999);
        p.bet(new Bet(2, 1));
        assertEquals(99999999-2, p.getAvailableChips());
    }
}