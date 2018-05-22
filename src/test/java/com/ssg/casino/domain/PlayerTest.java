package com.ssg.casino.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PlayerTest {

    @Test
    public void activeGameIsNull() { // ????
        Player player = new Player();
        assertNull(player.activeGame());
    }

    @Test
    public void getAvailableChipsIsZero() { // ????
        Player player = new Player();
        assertEquals(0l,player.getAvailableChips());
    }

    @Test(expected = CasinoGameException.class)
    public void multipleJoinsThrowException() throws CasinoGameException {
        Player player = new Player();
        player.joins(new RollDiceGame());
        player.joins(new RollDiceGame());
    }

    @Test
    public void singleJoinGameIsNotNull() throws CasinoGameException {
        Player player = new Player();
        player.joins(new RollDiceGame());
        assertNotNull(player.activeGame());
    }

    @Test
    public void afterLeaveGameIsNull() throws CasinoGameException {
        Player player = new Player();
        player.joins(new RollDiceGame());

        player.leave();
        assertNull(player.activeGame());
    }

    @Test
    public void buyPositiveChipsIsOk() throws CasinoGameException {
        Player player = new Player();
        player.buy(10);

        assertEquals(10,player.getAvailableChips());
    }

    @Test(expected = CasinoGameException.class)
    public void buyNegativeChipsThrowException() throws CasinoGameException {
        Player player = new Player();
        player.buy(-10);
    }

    @Test
    public void betChipsLessThanPlayerHaveIsOk() throws CasinoGameException {
        Player player = new Player();
        player.buy(12);
        player.joins(new RollDiceGame());
        Bet bet = new Bet(5, 5);
        player.bet(bet);
        assertEquals(7, player.getAvailableChips());
    }

    @Test
    public void win() {
    }

    @Test
    public void lose() {
    }
}