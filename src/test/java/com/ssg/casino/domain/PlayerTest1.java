package com.ssg.casino.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by ostkav15 22.05.18
 **/
public class PlayerTest1 {

    private Player newPlayer() {
        return new Player();
    }

    private RollDiceGame newRollDiceGame() {
        return  new RollDiceGame();
    }

    private Player newActivePlayer() throws CasinoGameException {
        Player newPlayer = newPlayer();
        newPlayer.joins(newRollDiceGame());
        return newPlayer;
    }


    @Test(expected = CasinoGameException.class)
    public void joins_ActivePlayer_ThrowException() throws CasinoGameException {
        Player activePlayer = newActivePlayer();

        activePlayer.joins(new RollDiceGame());
    }

    @Test
    public void joins_NewPlayer_NotEmptyActiveGame() throws CasinoGameException {
        Player newPlayer = newPlayer();

        newPlayer.joins(newRollDiceGame());

        assertNotNull(newPlayer.activeGame());
    }

    @Test
    public void leave_ActivePlayer_EmptyActiveGame() throws CasinoGameException {
        Player activePlayer = newActivePlayer();

        activePlayer.leave();

        assertNull(activePlayer.activeGame());
    }

    @Test
    public void buy_PositiveChips_isOk() throws CasinoGameException {
        Player player = new Player();

        player.buy(10);

        assertEquals(10,player.getAvailableChips());
    }

    @Test(expected = CasinoGameException.class)
    public void buy_NegativeChips_ThrowException() throws CasinoGameException {
        Player player = new Player();

        player.buy(-10);
    }

    @Test
    public void bet_ChipsAmountLessThanActivePlayerHas() throws CasinoGameException {
        Player activePlayer = newActivePlayer();
        activePlayer.buy(12);
        Bet bet = new Bet(5, 5);

        activePlayer.bet(bet);

        assertEquals(12-5, activePlayer.getAvailableChips());
    }



}
