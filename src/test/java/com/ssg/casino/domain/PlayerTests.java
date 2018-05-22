package com.ssg.casino.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class PlayerTests extends BaseTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void bet_newPlayerInGameWithChips_decreaseChipsAmountOnNumberOfBet() throws CasinoGameException {
        Player activePlayer = activePlayer();
        activePlayer.buy(10);

        activePlayer.bet(new Bet(2, 1));

        assertEquals(10 - 2, activePlayer.getAvailableChips());
    }

    @Test
    public void betMoreChipsThanHeHas_activePlayerWithChips_throwException() throws CasinoGameException {

        Player activePlayer = activePlayer();
        activePlayer.buy(10);

        expectedException.expect(CasinoGameException.class);

        activePlayer.bet(new Bet(12, 1));
    }
}