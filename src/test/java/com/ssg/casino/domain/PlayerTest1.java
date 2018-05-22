package com.ssg.casino.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by ostkav15 22.05.18
 **/
public class PlayerTest1 extends BaseTest {




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
    public void buy_PositiveChips_Successful() throws CasinoGameException {
        Player player = newPlayer();

        player.buy(10);

        assertEquals(10,player.getAvailableChips());
    }

    @Test(expected = CasinoGameException.class)
    public void buy_NegativeChips_ThrowException() throws CasinoGameException {
        Player player = newPlayer();

        player.buy(-10);
    }

    @Test
    public void bet_ChipsAmountLessThanActivePlayerHas_Successful() throws CasinoGameException {
        Player activePlayer = newActivePlayer();
        activePlayer.buy(12);

        activePlayer.bet(newBetByAmount(5));

        assertEquals(12-5, activePlayer.getAvailableChips());
    }



}
